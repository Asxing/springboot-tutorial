package com.holddie.boot.sourcecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/22 9:51
 */
@Slf4j
@Component
public class MyAwareTest implements MyAware {
    @Override
    public void setAware(ApplicationContext applicationContext, BeanFactory beanFactory) {
        log.error("MyAwareTest.setAware ===> applicationContext: " + applicationContext.getClass().getSimpleName() + ", beanFactory: " + beanFactory.getClass().getSimpleName());
    }
}
