package com.holddie.springboot.mybatis.config.redis.builder;

import com.holddie.springboot.mybatis.config.redis.configure.IRedisBuilder;
import com.holddie.springboot.mybatis.config.redis.configure.JedisSetting;
import com.holddie.springboot.mybatis.config.redis.configure.RedisConnectionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//@Component
public class StringRedisTemplateBuilder {
	private static Logger logger = LoggerFactory.getLogger(StringRedisTemplateBuilder.class);

	@Autowired
	private List<IRedisBuilder> redisBuilder;

	@Autowired
	private RedisConnectionConfig config;

	/**
	 * 构建锁
	 */
	private static final Lock LOCK = new ReentrantLock();

	public StringRedisTemplate build() {

		StringRedisTemplate redisTemplate = null;
		
		JedisSetting.loadPoolConfig(config);
		
		while (true) {
			try {
				LOCK.tryLock(10, TimeUnit.MILLISECONDS);
				if (redisTemplate == null) {

					IRedisBuilder redisBuilder = this.getRedisBuilder();
					JedisConnectionFactory jedisConnectionFactory = redisBuilder.buildConnectionFactory( );
					// 初始化连接pool
					jedisConnectionFactory.afterPropertiesSet();
					redisTemplate = new StringRedisTemplate();
					redisTemplate.setConnectionFactory(jedisConnectionFactory);
					return redisTemplate;
				}
			} catch (Exception e) {// 容错
				logger.error(e.getMessage(), e);
				break;
			} finally {
				LOCK.unlock();
			}
			try {
				TimeUnit.MILLISECONDS.sleep(200 + new Random().nextInt(1000));// 活锁
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return redisTemplate;
	}

	private IRedisBuilder getRedisBuilder() {
		System.out.println(config.getType());
		for (IRedisBuilder builder : redisBuilder) {
			if (builder.getType().name().equals(config.getType())) {
				return builder;
			}
		}
		throw new RuntimeException(  "没有找到对应的配置方式");
	}
}
