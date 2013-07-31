package com.flywet.platform.bi.web.service;

import com.flywet.platform.bi.core.exception.BIException;

public interface BIDomainDelegates {
	/**
	 * 通过语义定义ID获得模型对象
	 * 
	 * @param id
	 * @return
	 * @throws BIException
	 */
	public Object[] getDomainObject(Long id) throws BIException;
}