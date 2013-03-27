package com.plywet.platform.bi.web.service;

import java.util.List;

import org.apache.commons.vfs.FileObject;

import com.plywet.platform.bi.core.exception.BIException;
import com.plywet.platform.bi.delegates.utils.BIFileSystemCategory;
import com.plywet.platform.bi.delegates.vo.FilesysDirectory;
import com.plywet.platform.bi.delegates.vo.FilesysType;

public interface BIFileSystemDelegate {

	/**
	 * 查询根目录描述信息
	 * 
	 * @param category
	 * @param rootId
	 * @return
	 * @throws BIException
	 */
	public String getRootDesc(String category, long rootId) throws BIException;

	/**
	 * 获取文件系统所有类型
	 * 
	 * @return
	 * @throws BIException
	 */
	public List<FilesysType> getFilesysTypes() throws BIException;

	/**
	 * 获取文件系统根目录
	 * 
	 * @param typeId
	 * @return
	 * @throws BIException
	 */
	public List<FilesysDirectory> getFilesysRoots(BIFileSystemCategory cate)
			throws BIException;

	/**
	 * 拼装vfs文件
	 * 
	 * @param category
	 * @param workDir
	 * @param rootId
	 * @return
	 * @throws BIException
	 */
	public FileObject composeVfsObject(String category, String workDir,
			long rootId) throws BIException;

}