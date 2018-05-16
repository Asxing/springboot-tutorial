package com.holddie.springboot.freemarker.listener;

import com.holddie.springboot.freemarker.component.ApplicationContextRegister;
import com.holddie.springboot.freemarker.framework.SpringContextHolder;
import com.holddie.springboot.freemarker.framework.SpringUtil;
import com.holddie.springboot.freemarker.framework.cache.ICache;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/14 8:18
 */
@WebListener
public class TestListener implements ServletContextListener {

    @Autowired
    ICache cache;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ICache cache= this.cache;
        System.out.println(cache.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
