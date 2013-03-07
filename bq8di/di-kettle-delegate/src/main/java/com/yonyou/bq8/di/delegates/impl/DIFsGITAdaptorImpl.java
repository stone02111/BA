package com.yonyou.bq8.di.delegates.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yonyou.bq8.di.delegates.anno.DIDelegate;
import com.yonyou.bq8.di.delegates.intf.DIFsGITAdaptor;
import com.yonyou.bq8.di.delegates.utils.DIFileSystemCategory;
import com.yonyou.bq8.di.delegates.vo.FilesysDirectory;
import com.yonyou.bq8.di.exceptions.DIKettleException;

@DIDelegate(type = "db")
public class DIFsGITAdaptorImpl extends DIFsLocalAdaptorImpl implements
		DIFsGITAdaptor {
	private final Logger logger = Logger.getLogger(DIFsGITAdaptorImpl.class);

	@Override
	public List<FilesysDirectory> getRootDirectories() throws DIKettleException {
		return getRootDirectoriesByType(DIFileSystemCategory.FILESYS_TYPE_GIT
				.getId());
	}

}