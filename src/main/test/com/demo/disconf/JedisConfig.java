package com.demo.disconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

/**
 * Redis配置文件
 * @author chenty
 *
 */
@Service
@Scope("singleton")
@DisconfFile(filename = "redis.properties")
public class JedisConfig {

	private Logger logger = LoggerFactory.getLogger(JedisConfig.class);
	
	// 代表连接地址
	private String host;

	// 代表连接port
	private int port;

	/**
	 * 地址, 分布式文件配置
	 *
	 * @return
	 */
	@DisconfFileItem(name = "redis.host", associateField = "host")
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * 端口, 分布式文件配置
	 *
	 * @return
	 */
	@DisconfFileItem(name = "redis.port", associateField = "port")
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
