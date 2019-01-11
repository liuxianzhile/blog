package com.blog.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.BlogUserMapper;
import com.blog.model.BlogUser;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @file TestRedis.java
 * @author FuNian Cui
 * @date 2019年1月9日 上午9:33:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TestRedis {
	@Autowired
	BlogUserMapper blogUserMapper;
	
	@Test
	public void testJedisClient() {
		// 定义redis连接池
		JedisPool jedisPool = null;
		// 定义redis实例
		Jedis jedis = null;
		try {
			// 映射redis配置文件
			@SuppressWarnings("resource")
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-cache.xml");
			// 获取redis连接池
			jedisPool = (JedisPool) applicationContext.getBean("jedisPool");
			// 获取redis实例
			jedis = jedisPool.getResource();
			// 存值
			jedis.set("name", "rose");
			// 取值
			String name = jedis.get("name");
			// 输出控制台
			System.out.println(name);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if(jedis != null) jedis.close(); 
		}
	}
	
	
	
	@Test
	public void testJedisUtils() {
		// 定义redis的key
		String key = "name";
		// 定义接收对象
		BlogUser userInfo = null;
		// 判断key是否存在
		if (RedisUtil.exists("name")) {
			// 若不存在，则从数据库里面取出相应数据
			userInfo = blogUserMapper.selectById(null);
		    // 将相关的实体类集合转换成string,存入redis里面对应的key中
			RedisUtil.set(key, userInfo.getUserName());
		} else {
			// 若存在，则直接从redis里面取出相应数据
			String jsonString = RedisUtil.get(key);
			System.out.println(jsonString);
		}
	}
}