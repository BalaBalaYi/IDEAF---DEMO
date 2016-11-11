package com.demo.disconf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JedisConfig redis = ctx.getBean(JedisConfig.class);
		
		System.out.println(redis.getHost());
		
	}
	
}
