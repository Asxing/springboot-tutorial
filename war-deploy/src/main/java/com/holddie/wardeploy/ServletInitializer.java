package com.holddie.wardeploy;

import com.holddie.wardeploy.listener.TestListener;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WarDeployApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        this.logger = LogFactory.getLog(super.getClass());
        WebApplicationContext rootAppContext = createRootApplicationContext(servletContext);

        if (rootAppContext != null) {
//            servletContext.addListener(new ContextLoaderListener(rootAppContext));
            servletContext.addListener(new TestListener());
        } else
            this.logger.debug(
                    "No ContextLoaderListener registered, as createRootApplicationContext() did not return an application context");

    }
}
