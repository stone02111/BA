package com.plywet.platform.bi.web.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.plywet.platform.bi.core.exception.BIException;
import com.plywet.platform.bi.delegates.intf.BIReportAdaptor;
import com.plywet.platform.bi.delegates.utils.BIAdaptorFactory;
import com.plywet.platform.bi.web.service.BIReportDelegates;

@Service("bi.service.reportService")
public class BIReportService implements BIReportDelegates {
	private final Logger log = Logger.getLogger(BIReportService.class);

	@Override
	public Object[] getReportObject(Long id) throws BIException {
		BIReportAdaptor adaptor = BIAdaptorFactory
				.createAdaptor(BIReportAdaptor.class);

		Object[] report = adaptor.getReportObject(String.valueOf(id));
		// 如果是引用，再次查询 TODO

		if (report != null) {
			Object[] rtn = new Object[] { report[0], report[2] };
			return rtn;
		}

		return null;
	}

	public void saveReportObject(Long id, String xml) {
		BIReportAdaptor adaptor = BIAdaptorFactory
				.createAdaptor(BIReportAdaptor.class);
		// TODO 如果id不存在，插入一条记录

	}

}
