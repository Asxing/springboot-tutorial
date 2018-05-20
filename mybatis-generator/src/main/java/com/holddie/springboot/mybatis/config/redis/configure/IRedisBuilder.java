package com.holddie.springboot.mybatis.config.redis.configure;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * redis构建接口
 * @author fk
 * @version v6.4
 * @since v6.4
 * 2017年10月27日 下午2:05:40
 */
public interface IRedisBuilder {

    /**
     * 构建连接
     * @return
     */
    public JedisConnectionFactory buildConnectionFactory();

    /**
     * 类型
     * @return
     */
    public RedisType getType();
}
