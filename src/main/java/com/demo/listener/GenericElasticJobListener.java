package com.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

/**
 * Elastic-job 的任务监听器，此为全局监听器
 * @author chenty
 *
 */
public class GenericElasticJobListener implements ElasticJobListener {

	private Logger logger = LoggerFactory.getLogger(GenericElasticJobListener.class);
	
	@Override
	public void beforeJobExecuted(ShardingContexts shardingContexts) {
		// TODO Auto-generated method stub
		logger.info("do something before Job");
	}

	@Override
	public void afterJobExecuted(ShardingContexts shardingContexts) {
		// TODO Auto-generated method stub
		logger.info("do something after Job");
	}

}
