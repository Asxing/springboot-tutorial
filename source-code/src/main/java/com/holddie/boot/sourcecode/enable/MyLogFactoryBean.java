package com.holddie.boot.sourcecode.enable;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 10:13
 */
public class MyLogFactoryBean<T> extends AbstractMyLogFactoryBean<T> {

    public MyLogFactoryBean(Class<T> mapperInterface) {
        super();
    }

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     * <p>This method allows the bean instance to perform initialization only
     * possible when all bean properties have been set and to throw an
     * exception in the event of misconfiguration.
     * @exception Exception in the event of misconfiguration (such
     *                      as failure to set an essential property) or if initialization fails.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        T target = (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{getMapperInterface()}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "JDK:" + getLogSupport().invoke(method, args);
            }
        });
        setProxyTarget(target);
    }




}
