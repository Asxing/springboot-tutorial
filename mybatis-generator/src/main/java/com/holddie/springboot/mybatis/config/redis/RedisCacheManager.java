package com.holddie.springboot.mybatis.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by guoxirong on 2018/4/19.
 * modify by guoxirong on 2018/5/07
 */
@Component
public class RedisCacheManager {

    @Autowired
    RedisTemplate redisTemplate;

    @Caching(evict = {
            @CacheEvict(cacheNames = {"goods","gallery"}, keyGenerator = "shortKey", beforeInvocation = true),
            @CacheEvict(cacheNames = {"goods","gallery"}, key = "#goods_id", beforeInvocation = true),
            @CacheEvict(cacheNames = {"goods","gallery"}, key = "#sku", beforeInvocation = true)
    })
    public void updateCacheByGoodsku(Integer goods_id, String sku) {
        redisTemplate.delete("GOODS" + goods_id);
        redisTemplate.delete("SKU"+sku);
    }
}