package com.holddie.springboot.mybatis.config.freemarker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;
import javax.servlet.Servlet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Freemarker 配置文件
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 18:20
 */
// 使用Configuration注解，自动构造一些内部定义的bean
@Configuration
// 需要freemarker.template.Configuration和FreeMarkerConfigurationFactory这两个类存在在classpath中才会进行自动配置
@ConditionalOnClass({freemarker.template.Configuration.class,
        FreeMarkerConfigurationFactory.class})
// 本次自动配置需要依赖WebMvcAutoConfiguration这个配置类配置之后触发。这个WebMvcAutoConfiguration内部会配置很多Wen基础性的东西，
// 比如RequestMappingHandlerMapping、RequestMappingHandlerAdapter等
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
// 使用FreeMarkerProperties类中的配置
@EnableConfigurationProperties(FreeMarkerProperties.class)
public class FreemarkerConfig {
    private static final Log logger = LogFactory
            .getLog(FreemarkerConfig.class);

//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private FreeMarkerProperties properties;
//
//    @PostConstruct // 构造之后调用的方法，主要检查模板位置是否存在
//    public void checkTemplateLocationExists() {
//        if (this.properties.isCheckTemplateLocation()) {
//            TemplateLocation templatePathLocation = null;
//            List<TemplateLocation> locations = new ArrayList<TemplateLocation>();
//            for (String templateLoaderPath : this.properties.getTemplateLoaderPath()) {
//                TemplateLocation location = new TemplateLocation(templateLoaderPath);
//                locations.add(location);
//                if (location.exists(this.applicationContext)) {
//                    templatePathLocation = location;
//                    break;
//                }
//            }
//            if (templatePathLocation == null) {
//                logger.warn("Cannot find template location(s): " + locations
//                        + " (please add some templates, "
//                        + "check your FreeMarker configuration, or set "
//                        + "spring.freemarker.checkTemplateLocation=false)");
//            }
//        }
//    }
//
//    protected static class FreeMarkerConfiguration {
//
//        @Autowired
//        protected FreeMarkerProperties properties;
//
//        protected void applyProperties(FreeMarkerConfigurationFactory factory) {
//            factory.setTemplateLoaderPaths(this.properties.getTemplateLoaderPath());
//            factory.setPreferFileSystemAccess(this.properties.isPreferFileSystemAccess());
//            factory.setDefaultEncoding(this.properties.getCharsetName());
//            Properties settings = new Properties();
//            settings.putAll(this.properties.getSettings());
//            factory.setFreemarkerSettings(settings);
//        }
//
//    }
//
//    @Configuration
//    @ConditionalOnNotWebApplication // 非Web项目的自动配置
//    public static class FreeMarkerNonWebConfiguration extends FreeMarkerConfiguration {
//
//        @Bean
//        @ConditionalOnMissingBean
//        public FreeMarkerConfigurationFactoryBean freeMarkerConfiguration() {
//            FreeMarkerConfigurationFactoryBean freeMarkerFactoryBean = new FreeMarkerConfigurationFactoryBean();
//            applyProperties(freeMarkerFactoryBean);
//            return freeMarkerFactoryBean;
//        }
//
//    }
//
//    @Configuration // 自动配置的类
//    @ConditionalOnClass(Servlet.class) // 需要运行在Servlet容器下
//    @ConditionalOnWebApplication // 需要在Web项目下
//    public static class FreeMarkerWebConfiguration extends FreeMarkerConfiguration {
//
//        @Bean
//        @ConditionalOnMissingBean(FreeMarkerConfig.class)
//        public FreeMarkerConfigurer freeMarkerConfigurer() {
//            FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//            applyProperties(configurer);
//            return configurer;
//        }
//
//        @Bean
//        public freemarker.template.Configuration freeMarkerConfiguration(
//                FreeMarkerConfig configurer) {
//            return configurer.getConfiguration();
//        }
//
//        @Bean
//        // 没有配置freeMarkerViewResolver这个bean的话，会自动构造一个freeMarkerViewResolver
//        @ConditionalOnMissingBean(name = "freeMarkerViewResolver")
//        // 配置文件中开关开启的话，才会构造
//        @ConditionalOnProperty(name = "spring.freemarker.enabled", matchIfMissing = true)
//        public FreeMarkerViewResolver freeMarkerViewResolver() {
//            // 构造了freemarker的ViewSolver，这就是一开始我们分析的为什么没有设置ViewResolver，但是最后却还是存在的原因
//            FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//            this.properties.applyToMvcViewResolver(resolver);
//            return resolver;
//        }
//
//    }
}
