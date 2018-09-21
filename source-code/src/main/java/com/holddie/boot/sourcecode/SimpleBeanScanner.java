package com.holddie.boot.sourcecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/22 11:49
 */
@Component
@Slf4j
public class SimpleBeanScanner implements EnvironmentAware, ResourceLoaderAware {
    private Environment environment;
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void scan() {
        log.info("======================== start scan ==============================");
        MyClassScanner myClassScanner = new MyClassScanner();
        myClassScanner.setEnvironment(environment);
        myClassScanner.setResourceLoader(resourceLoader);
        myClassScanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        log.info(myClassScanner.findCandidateComponents("com.holddie.boot.sourcecode").toString());
        log.info("======================== end scan   =============================");

    }


    /**
     * Set the {@code Environment} that this component runs in.
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
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
    }
}
