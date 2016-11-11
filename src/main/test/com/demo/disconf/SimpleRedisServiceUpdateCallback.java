package com.demo.disconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfUpdateService;
import com.baidu.disconf.client.common.update.IDisconfUpdate;

/**
 * 更新Redis配置时的回调函数
 * @author chenty
 *
 */
@Service
@Scope("singleton")
@DisconfUpdateService(classes = {JedisConfig.class})
public class SimpleRedisServiceUpdateCallback implements IDisconfUpdate {
	
	private Logger logger = LoggerFactory.getLogger(SimpleRedisService.class);
	
	@Autowired
	private SimpleRedisService simpleRedisService;

	@Override
	public void reload() throws Exception {
		
		simpleRedisService.changeJedis();
		
	}

}
