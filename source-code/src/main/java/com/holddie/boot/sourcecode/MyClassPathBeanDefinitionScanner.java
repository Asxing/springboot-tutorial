package com.holddie.boot.sourcecode;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/22 15:13
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    /**
     * Create a new {@code ClassPathBeanDefinitionScanner} for the given bean factory.
     * @param registry the {@code BeanFactory} to load bean definitions into, in the form
     *                 of a {@code BeanDefinitionRegistry}
     */
    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * Determine whether the given bean definition qualifies as candidate.
     * <p>The default implementation checks whether the class is not an interface
     * and not dependent on an enclosing class.
     * <p>Can be overridden in subclasses.
     * @param beanDefinition the bean definition to check
     * @return whether the bean definition qualifies as a candidate component
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return (metadata.isIndependent() && (metadata.isConcrete() || metadata.isAbstract() || metadata.isInterface()));
    }
}
