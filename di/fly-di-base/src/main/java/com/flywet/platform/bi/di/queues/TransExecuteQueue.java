package com.flywet.platform.bi.di.queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.log4j.Logger;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransListener;
import org.pentaho.di.trans.TransStoppedListener;

import com.flywet.platform.bi.core.exception.BIException;
import com.flywet.platform.bi.core.exception.BIPoolException;
import com.flywet.platform.bi.core.utils.PropertyUtils;
import com.flywet.platform.bi.di.model.TransExecuteWapper;

public class TransExecuteQueue {

	private static TransExecuteQueue delegate;

	private AtomicBoolean init = new AtomicBoolean(false);

	private int maxPoolSize = 3;

	private int maxActiveSize = 3;

	// 请求执行转换的队列
	private List<TransExecuteWapper> requests = Collections
			.synchronizedList(new ArrayList<TransExecuteWapper>());

	private Map<Trans, TransExecuteWapper> actives = Collections
			.synchronizedMap(new HashMap<Trans, TransExecuteWapper>());

	public void initPool() throws BIException {
		if (!init.getAndSet(true)) {
			// 初始化poolSize
			maxPoolSize = PropertyUtils
					.getIntProperty(PropertyUtils.TRANS_POOL_MAX_SIZE);

			// 初始化运行队列
			maxActiveSize = PropertyUtils
					.getIntProperty(PropertyUtils.TRANS_POOL_MAX_ACTIVE_SIZE);

			init.set(true);
		}
	}

	public synchronized static TransExecuteQueue instance() throws BIException {
		if (delegate == null) {
			delegate = new TransExecuteQueue();
			delegate.initPool();
		}
		return delegate;
	}

	public synchronized void offer(TransExecuteWapper vo) throws BIException {
		if (checkDuplicateTrans(vo.getSingle())) {
			throw new BIPoolException("重复提交转换");
		}
		if (actives.size() >= maxActiveSize) {
			if (requests.size() >= maxPoolSize) {
				throw new BIPoolException("超出最大缓存数量");
			} else {
				requests.add(vo);
			}
		} else {
			run(vo);
		}
	}

	public boolean checkDuplicateTrans(String single) {
		if (Const.isEmpty(single)) {
			return false;
		}
		for (TransExecuteWapper tpw : actives.values()) {
			if (single.equals(tpw.getSingle())) {
				return true;
			}
		}
		for (TransExecuteWapper tpw : requests) {
			if (single.equals(tpw.getSingle())) {
				return true;
			}
		}
		return false;
	}

	public synchronized void poll(Trans trans) throws BIException {
		actives.remove(trans);
		if (this.requests.isEmpty()) {
			return;
		}

		TransExecuteWapper vo = this.requests.remove(0);
		run(vo);
	}

	public synchronized void run(TransExecuteWapper vo) throws BIException {
		try {
			Trans trans = new Trans(vo.getTransMeta());
			// trans.setRepository(rep);
			trans.addTransListener(new TransPoolListener());
			trans.addTransStoppedListener(new TransPoolStoppedListener());

			trans.initializeVariablesFrom(null);
			trans.getTransMeta().setInternalKettleVariables(trans);
			// trans.setLogLevel(log.getLogLevel());

			String[] transParams = trans.listParameters();
			for (String param : transParams) {
				String value = vo.getParamValue(param);
				if (value != null) {
					trans.setParameterValue(param, value);
				}
			}

			trans.activateParameters();

			actives.put(trans, vo);

			trans.execute(null);
			// trans.waitUntilFinished();

			// 参考Pan.java 390

			// TODO

		} catch (Exception e) {
			throw new BIPoolException("运行转换出现错误。");
		}

	}
}

class TransPoolStoppedListener implements TransStoppedListener {

	private final Logger logger = Logger.getLogger(TransExecuteQueue.class);

	@Override
	public void transStopped(Trans trans) {
		try {
			TransExecuteQueue.instance().poll(trans);
		} catch (Exception e) {
			logger.error("执行转换运行池执行出现错误。");
		}
	}

}

class TransPoolListener implements TransListener {

	@Override
	public void transActive(Trans trans) {

	}

	@Override
	public void transFinished(Trans trans) throws KettleException {
		try {
			TransExecuteQueue.instance().poll(trans);
		} catch (Exception e) {
			throw new KettleException("执行转换运行池执行出现错误。");
		}
	}

	@Override
	public void transIdle(Trans trans) {

	}

	@Override
	public void transStarted(Trans trans) throws KettleException {

	}

}
