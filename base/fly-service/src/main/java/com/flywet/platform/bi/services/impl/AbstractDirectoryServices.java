package com.flywet.platform.bi.services.impl;

import org.apache.log4j.Logger;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.LongObjectId;
import org.pentaho.di.repository.Repository;
import org.pentaho.di.repository.RepositoryDirectory;
import org.pentaho.di.repository.RepositoryDirectoryInterface;

import com.flywet.platform.bi.component.components.breadCrumb.BreadCrumbMeta;
import com.flywet.platform.bi.component.components.breadCrumb.BreadCrumbNodeMeta;
import com.flywet.platform.bi.component.components.browse.BrowseMeta;
import com.flywet.platform.bi.component.components.browse.BrowseNodeMeta;
import com.flywet.platform.bi.component.utils.HTML;
import com.flywet.platform.bi.core.exception.BIException;
import com.flywet.platform.bi.core.pools.RepPool;
import com.flywet.platform.bi.core.utils.Utils;
import com.flywet.platform.bi.delegates.enums.BIDirectoryCategory;

public abstract class AbstractDirectoryServices {

	private final static Logger log = Logger
			.getLogger(AbstractDirectoryServices.class);

	public RepositoryDirectoryInterface getRootDirectory(
			BIDirectoryCategory category) {
		RepositoryDirectory root = new RepositoryDirectory();
		root.setObjectId(new LongObjectId(category.getRootId()));
		return root;
	}

	public RepositoryDirectoryInterface getDirecotry(long id,
			BIDirectoryCategory category) throws BIException {
		Repository rep = null;
		try {
			rep = RepPool.instance().borrowRep();

			RepositoryDirectoryInterface root = getRootDirectory(category);

			RepositoryDirectoryInterface rd = rep.loadRepositoryDirectoryTree(
					root).findDirectory(new LongObjectId(id));

			return rd;

		} catch (KettleException e) {
			log.error("创建父目录页面出现错误。");
			throw new BIException("创建父目录页面出现错误。");
		} finally {
			RepPool.instance().returnRep(rep);
		}
	}

	protected BreadCrumbMeta parentDirectories(Long id, String tital,
			String prefixPath, BIDirectoryCategory category) throws BIException {
		Repository rep = null;
		try {
			BreadCrumbMeta bce = new BreadCrumbMeta();
			rep = RepPool.instance().borrowRep();
			RepositoryDirectoryInterface root = getRootDirectory(category);
			RepositoryDirectoryInterface rd = rep.loadRepositoryDirectoryTree(
					root).findDirectory(new LongObjectId(id));
			bce.addEvent("click", "Flywet.browse.changeDir");
			String name;
			while (true) {
				name = rd.getName();
				if (rd.isRoot()) {
					name = tital;
				}
				BreadCrumbNodeMeta node = new BreadCrumbNodeMeta(rd
						.getObjectId().getId(), name, prefixPath
						+ rd.getObjectId().getId(), "");

				bce.addContentFirse(node);

				if (rd.getParent() == null) {
					break;
				} else {
					rd = rd.getParent();
				}
			}
			return bce;

		} catch (KettleException e) {
			log.error("创建父目录页面出现错误。");
			throw new BIException("创建父目录页面出现错误。");
		} finally {
			RepPool.instance().returnRep(rep);
		}
	}

	protected void subDirectory(Long id, BrowseMeta browse, String prefixPath,
			BIDirectoryCategory category) throws BIException {
		Repository rep = null;
		try {
			rep = RepPool.instance().borrowRep();
			RepositoryDirectoryInterface root = getRootDirectory(category);
			RepositoryDirectoryInterface rd = rep.loadRepositoryDirectoryTree(
					root).findDirectory(new LongObjectId(id));
			for (RepositoryDirectoryInterface subrd : rd.getChildren()) {
				BrowseNodeMeta node = new BrowseNodeMeta();
				node.setId(subrd.getObjectId().getId());
				node.addAttribute(BrowseNodeMeta.ATTR_DISPLAY_NAME, subrd
						.getName());
				node.addAttribute(HTML.ATTR_TYPE, Utils.DOM_NODE);
				node.addAttribute(HTML.ATTR_SRC, prefixPath
						+ subrd.getObjectId().getId());

				node.addEvent("mouseup", "Flywet.browse.showOperationForDir");
				node.addEvent("dblclick", "Flywet.browse.changeDir");
				browse.addContent(node);
			}

		} catch (KettleException e) {
			log.error("创建子目录页面出现错误。");
			throw new BIException("创建子目录页面出现错误。");
		} finally {
			RepPool.instance().returnRep(rep);
		}

	}

}