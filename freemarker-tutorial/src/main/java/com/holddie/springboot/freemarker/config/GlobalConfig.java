package com.holddie.springboot.freemarker.config;

import com.holddie.springboot.freemarker.framework.SpringContextHolder;
import com.holddie.springboot.freemarker.framework.cache.ICache;
import com.holddie.springboot.freemarker.framework.cache.RedisCacheImpl;
import com.holddie.springboot.freemarker.listener.TestListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/14 8:17
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

//    @Bean
//    public ServletListenerRegistrationBean<ContextLoaderListener> serssionListenerBean(){
//        ServletListenerRegistrationBean<ContextLoaderListener>
//                sessionListener = new ServletListenerRegistrationBean<ContextLoaderListener>(new ContextLoaderListener());
//        sessionListener.setOrder(1);
//        return sessionListener;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean<TestListener> serssionListenerBean1(){
//        ServletListenerRegistrationBean<TestListener>
//                sessionListener = new ServletListenerRegistrationBean<TestListener>(new TestListener());
//        sessionListener.setOrder(2);
//        return sessionListener;
//    }

}
