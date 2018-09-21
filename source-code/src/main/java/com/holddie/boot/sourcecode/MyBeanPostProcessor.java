package com.holddie.boot.sourcecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 初始化上下文设置参数值
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/21 9:30
 */
@Component
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IMyBean) {
            log.error("===========> postProcessBeforeInitialization");
            MyBean myBean = (MyBean) bean;
            if (myBean.getDesc() == null) {
                myBean.setDesc("123");
            }
        }


        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IMyBean) {
            log.error("===========> postProcessAfterInitialization ");
            IMyBean myBean = (IMyBean) bean;
            if (myBean.getCustomValue() == null) {
                myBean.setCustomValue("defaultValue");
            }
        }
        return bean;
    }
}
