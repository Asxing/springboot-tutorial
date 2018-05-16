package com.holddie.wardeploy.config.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Set;

/**
 * Redis配置
 * @author kingapex
 * 2017年8月2日上午11:52:50
 *
 * 修改文件位置,增加RedissonClinet的配置
 * @version 2.0
 * @since 6.4
 */
@Configuration
public class RedisConfig {

    @Autowired
    private List<IRedisBuilder> redisBuilder;

    @Autowired
    private RedisConnectionConfig config;

	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setEnableTransactionSupport(false);
		return redisTemplate;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
		return redisTemplate;
	}

	@Bean
	JedisConnectionFactory jedisConnectionFactory(RedisConnectionConfig config) {
        JedisSetting.loadPoolConfig(config);
        IRedisBuilder redisBuilder = this.getRedisBuilder();
        JedisConnectionFactory jedisConnectionFactory = redisBuilder.buildConnectionFactory();
//        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
	}

	@Bean
	public RedissonClient redissonClient(JedisConnectionFactory jedisConnectionFactory, RedisConnectionConfig config) {
 		Config rconfig = null;
		String type  = config.getType();

		//独立模式
		if( RedisType.standalone.name().equals(type) ){
			rconfig = new Config();
			RedisStandaloneConfiguration standaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
			String host  = standaloneConfiguration.getHostName();
			int port = standaloneConfiguration.getPort();
			SingleServerConfig singleServerConfig =  rconfig.useSingleServer().setAddress("redis://" + host+":" + port);
			if(standaloneConfiguration.getPassword().isPresent()){
				String password  = new String(standaloneConfiguration.getPassword().get() );
				singleServerConfig.setPassword(password);
			}
			singleServerConfig
                    .setConnectionPoolSize(250)
                    .setConnectionMinimumIdleSize(50)
                    .setRetryInterval(10000)
                    .setRetryAttempts(5)
                    .setConnectTimeout(40000)
                    .setTimeout(30000)
                    .setReconnectionTimeout(30000);
		}

		//哨兵模式
		if( RedisType.sentinel.name().equals(type) ){
			rconfig = new Config();
			RedisSentinelConfiguration sentinelConfiguration =  jedisConnectionFactory.getSentinelConfiguration();
			String masterName  =  sentinelConfiguration.getMaster().getName();
			Set<RedisNode> nodeSet =sentinelConfiguration.getSentinels();

			SentinelServersConfig sentinelServersConfig = rconfig.useSentinelServers().setMasterName(masterName);
			if (sentinelConfiguration.getPassword().isPresent()) {
				sentinelServersConfig.setPassword(new String(sentinelConfiguration.getPassword().get()));
			}

			for (RedisNode node : nodeSet){
				sentinelServersConfig.addSentinelAddress("redis://"+node.asString());
			}
			sentinelServersConfig
                    .setMasterConnectionMinimumIdleSize(50)
                    .setMasterConnectionPoolSize(250)
                    .setSlaveConnectionMinimumIdleSize(50)
                    .setSlaveConnectionPoolSize(250)
                    .setRetryInterval(10000)
                    .setRetryAttempts(5)
                    .setConnectTimeout(40000)
                    .setTimeout(30000)
                    .setReconnectionTimeout(30000);
		}

		//集群模式
		if( RedisType.cluster.name().equals(type) ){
			rconfig = new Config();
			RedisClusterConfiguration clusterConfiguration =  jedisConnectionFactory.getClusterConfiguration();
			Set<RedisNode> nodeSet = clusterConfiguration.getClusterNodes();
			ClusterServersConfig clusterServersConfig =  rconfig.useClusterServers();
			if (clusterConfiguration.getPassword().isPresent()) {
				clusterServersConfig.setPassword(new String(clusterConfiguration.getPassword().get()));
			}
			for (RedisNode node : nodeSet){
				clusterServersConfig.addNodeAddress("redis://"+node.asString());
			}
            clusterServersConfig
                    .setMasterConnectionMinimumIdleSize(50)
                    .setMasterConnectionPoolSize(250)
                    .setSlaveConnectionMinimumIdleSize(50)
                    .setSlaveConnectionPoolSize(250)
                    .setRetryInterval(10000)
                    .setRetryAttempts(5)
                    .setConnectTimeout(40000)
                    .setTimeout(30000)
                    .setReconnectionTimeout(50000);
		}

		if(  rconfig == null){
			throw  new RuntimeException("错误的redis 类型，请检查 redis.type参数");
		}
		RedissonClient redisson = Redisson.create(rconfig);
		return  redisson;
	}

    private IRedisBuilder getRedisBuilder() {
        for (IRedisBuilder builder : redisBuilder) {
            if (builder.getType().name().equals(config.getType())) {
                return builder;
            }
        }
        return null;
//        throw new ResourceNotFoundException(ErrorCode.RESOURCE_NOT_FOUND, "错误的redis 配置类型，请检查");
    }


}
