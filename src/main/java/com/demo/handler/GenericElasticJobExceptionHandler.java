package com.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dangdang.ddframe.job.executor.handler.JobExceptionHandler;

public class GenericElasticJobExceptionHandler implements JobExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GenericElasticJobExceptionHandler.class);

	@Override
	public void handleException(String jobName, Throwable cause) {
		// TODO Auto-generated method stub
		logger.warn("do something when exception");
	}

}
