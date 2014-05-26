package com.flywet.platform.bi.pivot.model;

import com.flywet.platform.bi.core.exception.BIException;
import com.tonbeller.wcf.controller.RequestContext;

/**
 * 区域对象的接口类
 * 
 * @author PeterPan
 * 
 */
public interface IRegionObject extends IJSONObjectable {

	public static final String PROP_NAME_REGION_OBJECT_TYPE = "type";
	public static final String PROP_NAME_REGION_DATA = "regionData";

	/**
	 * 初始化区域模型
	 * 
	 * @throws BIException
	 */
	public void init(RequestContext context) throws BIException;

	/**
	 * 获得区域对象的类型名称
	 * 
	 * @return
	 */
	public String getTypeName();

}
