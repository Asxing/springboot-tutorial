package com.holddie.boot.sourcecode.enable;


import org.springframework.aop.framework.DefaultAopProxyFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 10:12
 */
public abstract class AbstractMyLogFactoryBean<T> extends DefaultAopProxyFactory implements InitializingBean {

    private LogSupport logSupport;

    private T target;

    private Class<T> mapperInterface;

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public void setLogSupport(DefaultLogSupport logSupport) {
        this.logSupport = logSupport;
    }

    public LogSupport getLogSupport() {
        return logSupport;
    }

    public void setProxyTarget(T target) {
        this.target = target;
    }

}
