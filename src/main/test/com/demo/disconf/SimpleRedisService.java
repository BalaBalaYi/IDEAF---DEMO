package com.demo.disconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

/**
 * Redis配置操作
 * @author chenty
 *
 */
@Service
@Scope("singleton")
public class SimpleRedisService implements InitializingBean, DisposableBean {

	private Logger logger = LoggerFactory.getLogger(SimpleRedisService.class);
	
	// jedis 实例
	private Jedis jedis = null;

	/**
	 * 分布式配置
	 */
	@Autowired
	private JedisConfig jedisConfig;

	/**
	 * 关闭
	 */
	public void destroy() throws Exception {
	
		if (jedis != null) {
			jedis.disconnect();
		}
	}

	/**
	 * 进行连接
	 */
	public void afterPropertiesSet() throws Exception {
	
		jedis = JedisUtil.createJedis(jedisConfig.getHost(),
				jedisConfig.getPort());
	}

	/**
	 * 获取一个值
	 *
	 * @param key
	 * @return
	 */
	public String getKey(String key) {
		if (jedis != null) {
			return jedis.get(key);
		}
	
		return null;
	}
	
	/**
	 * 更改Jedis
	 */
	public void changeJedis() {

		logger.info("start to change jedis hosts to: " + jedisConfig.getHost()
			+ " : " + jedisConfig.getPort());
		
		jedis = JedisUtil.createJedis(jedisConfig.getHost(),
				jedisConfig.getPort());
		
		logger.info("change ok.");
	}
}
