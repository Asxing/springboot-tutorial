package com.holddie.springboot.mybatis.config.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

/**
 * Created by guoxirong on 2018/4/17.
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
    public static final String SPLIT_CHAR = ":";

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager cacheManager = RedisCacheManager.create(redisConnectionFactory);
        return cacheManager;
    }

    @Bean("fullKey")
    public KeyGenerator fullKeyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(o.getClass().getName()).append(SPLIT_CHAR).append(method.getName());
            for (Object obj : objects) {
                sb.append(SPLIT_CHAR).append(transferObject(obj));
            }
            return sb.toString();
        };
    }

    @Bean("shortKey")
    public KeyGenerator shortKeyGenerator() {
        return (o, method, objects) -> {
            StringBuilder sb = new StringBuilder();
            if (objects.length == 0) {
                sb.append(o.getClass().getName()).append(SPLIT_CHAR).append(method.getName());
            } else {
                sb.append(transferObject(objects[0]));
                for (int i = 1; i < objects.length; i++) {
                    sb.append(SPLIT_CHAR).append(transferObject(objects[i]));
                }
            }
            return sb.toString();
        };
    }

    public String transferObject(Object object) {
        return object == null ? "" : object.toString();
    }

}
