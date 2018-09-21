package com.holddie.boot.sourcecode;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/22 9:45
 */
public interface MyAware extends Aware {
    void setAware(ApplicationContext applicationContext, BeanFactory beanFactory);
}
