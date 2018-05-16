package com.holddie.wardeploy.config;

import com.holddie.wardeploy.framework.SpringContextHolder;
import com.holddie.wardeploy.framework.cache.ICache;
import com.holddie.wardeploy.framework.cache.RedisCacheImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 全局定义
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/14 16:23
 */
@Configuration
public class GlobalConfig {

    @Bean
    @Lazy(false)
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    ICache cache(RedisTemplate redisTemplate) {
        return new RedisCacheImpl(redisTemplate);
    }
}
