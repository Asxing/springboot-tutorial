package com.holddie.springboot.freemarker.config;

import com.holddie.springboot.freemarker.listener.TestListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyAdditionListeners extends SpringBootServletInitializer {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext rootAppContext = createRootApplicationContext(servletContext);
        if (rootAppContext != null) {
            servletContext.addListener(new ContextLoaderListener());
            servletContext.addListener(new TestListener());
        } else {
            this.logger.debug("No ContextLoaderListener registered, as "
                    + "createRootApplicationContext() did not "
                    + "return an application context");
        }
    }

}