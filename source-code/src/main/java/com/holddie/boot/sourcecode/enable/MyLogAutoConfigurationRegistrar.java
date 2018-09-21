package com.holddie.boot.sourcecode.enable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 10:03
 */
@Slf4j
public class MyLogAutoConfigurationRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;
    private Environment environment;


    /**
     * Set the {@code Environment} that this component runs in.
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        if (log.isDebugEnabled()) {
            log.debug("setEnvironment");
        }
    }

    /**
     * Set the ResourceLoader that this object runs in.
     * <p>This might be a ResourcePatternResolver, which can be checked
     * through {@code instanceof ResourcePatternResolver}. See also the
     * {@code ResourcePatternUtils.getResourcePatternResolver} method.
     * <p>Invoked after population of normal bean properties but before an init callback
     * like InitializingBean's {@code afterPropertiesSet} or a custom init-method.
     * Invoked before ApplicationContextAware's {@code setApplicationContext}.
     * @param resourceLoader ResourceLoader object to be used by this object
     * @see ResourcePatternResolver
     * @see ResourcePatternUtils#getResourcePatternResolver
     */
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        if (log.isDebugEnabled()) {
            log.debug("setResourceLoader");
        }
    }

    /**
     * Register bean definitions as necessary based on the given annotation metadata of
     * the importing {@code @Configuration} class.
     * <p>Note that {@link BeanDefinitionRegistryPostProcessor} types may <em>not</em> be
     * registered here, due to lifecycle constraints related to {@code @Configuration}
     * class processing.
     * @param importingClassMetadata annotation metadata of the importing class
     * @param registry               current bean definition registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        if (log.isDebugEnabled()) {
            log.debug("registerBeanDefinitinos");
        }

        // 获取自动 log 配置的 basePackage
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableMyLogAutoConfiguration.class.getName()));

        String basePackage = annotationAttributes.getString("basePackage");

        // 获取代理类
        Class<? extends AbstractFactoryBean> implClass = annotationAttributes.getClass("implClass");

        // 扫描基础包下所有带有MyLogScanner注解的接口
        MyLogClasspathScanner scanner = new MyLogClasspathScanner(registry);
        scanner.setResourceLoader(resourceLoader);
        scanner.addIncludeFilter(new AnnotationTypeFilter(MyLogScanner.class));

        // exclude package-info.java
        scanner.addExcludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                String className = metadataReader.getClassMetadata().getClassName();
                return className.endsWith("package-info");
            }
        });

        scanner.setFactoryBeanImplClass(implClass);

        scanner.doScan(basePackage);
    }
}
