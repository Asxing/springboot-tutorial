package com.holddie.springboot.mybatis.common.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis的cache实现
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/18 18:43
 */
public class RedisCacheImpl implements ICache {

    private RedisTemplate redisTemplate;

    public RedisCacheImpl(RedisTemplate redisTemplate) {

        this.redisTemplate = redisTemplate;
    }

    public RedisCacheImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object get(Object key) {

        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void put(Object key, Object value) {

        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void put(Object key, Object value, int exp) {

        redisTemplate.opsForValue().set(key, value, exp, TimeUnit.SECONDS);
    }

    @Override
    public void remove(Object key) {

        redisTemplate.delete(key);
    }

    @Override
    public void clear() {

        Set keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
    }

}
