package com.holddie.springboot.freemarker;

import com.holddie.springboot.freemarker.framework.SpringUtil;
import com.holddie.springboot.freemarker.framework.cache.ICache;
import com.holddie.springboot.freemarker.framework.cache.RedisCacheImpl;
import com.holddie.springboot.freemarker.listener.TestListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@Configuration
@ServletComponentScan
public class FreemarkerTutorialApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static void main(String[] args) {

        ApplicationContext app = SpringApplication.run(FreemarkerTutorialApplication.class, args);
        SpringUtil.setApplicationContext(app);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FreemarkerTutorialApplication.class);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        application.listeners(ContextLoaderListener.class,TestListener.class);
//        return application.sources(DemoWarApplication.class);
//    }
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        WebApplicationContext rootAppContext = createRootApplicationContext(servletContext);
//        if (rootAppContext != null) {
//            servletContext.addListener(new ContextLoaderListener(rootAppContext));
//            servletContext.addListener(new TestListener());
//        } else {
//            this.logger.debug("No ContextLoaderListener registered, as "
//                    + "createRootApplicationContext() did not "
//                    + "return an application context");
//        }
//    }

}
