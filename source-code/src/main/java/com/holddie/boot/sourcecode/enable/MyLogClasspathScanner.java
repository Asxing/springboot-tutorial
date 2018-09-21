package com.holddie.boot.sourcecode.enable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Objects;
import java.util.Set;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 10:24
 */
@Slf4j
public class MyLogClasspathScanner extends ClassPathBeanDefinitionScanner {

    private Class<? extends AbstractFactoryBean> factoryBeanImplClass;

    /**
     * Create a new {@code ClassPathBeanDefinitionScanner} for the given bean factory.
     * @param registry the {@code BeanFactory} to load bean definitions into, in the form
     *                 of a {@code BeanDefinitionRegistry}
     */
    public MyLogClasspathScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    /**
     * Perform a scan within the specified base packages,
     * returning the registered bean definitions.
     * <p>This method does <i>not</i> register an annotation config processor
     * but rather leaves this up to the caller.
     * @param basePackages the packages to check for annotated classes
     * @return set of beans registered if any for tooling registration purposes (never {@code null})
     */
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        log.info("find beanBeanDefinitions: " + beanDefinitions);
        if (!beanDefinitions.isEmpty()) {
            for (BeanDefinitionHolder holder : beanDefinitions) {
                GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
                definition.getPropertyValues().addPropertyValue("mapperInterface", Objects.requireNonNull(definition.getBeanClassName()));
                // 设置Bean工厂和对应的属性值
                definition.setBeanClass(this.factoryBeanImplClass);
                definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
            }
        }
        return beanDefinitions;
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
        return (beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent());
    }

    public void setFactoryBeanImplClass(Class<? extends AbstractFactoryBean> factoryBeanImplClass) {
        this.factoryBeanImplClass = factoryBeanImplClass;
    }

    /**
     * Check the given candidate's bean name, determining whether the corresponding
     * bean definition needs to be registered or conflicts with an existing definition.
     * @param beanName       the suggested name for the bean
     * @param beanDefinition the corresponding bean definition
     * @return {@code true} if the bean can be registered as-is;
     * {@code false} if it should be skipped because there is an
     * existing, compatible bean definition for the specified name
     */
    @Override
    protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) throws IllegalStateException {
        if (super.checkCandidate(beanName, beanDefinition)) {
            return true;
        } else {
            log.warn("Skipping MapperFactoryBean with name '" + beanName + "' and ' " + beanDefinition.getBeanClassName() + "' mapperInterface"
                    + ". Bean already defined with the same name!");
            return false;
        }
    }
}
