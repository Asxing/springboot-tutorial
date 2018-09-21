package com.holddie.boot.sourcecode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/22 11:52
 */
@Slf4j
public class MyClassScanner extends ClassPathScanningCandidateComponentProvider {
    MyClassScanner() {
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
        return (metadata.isIndependent() && (metadata.isAbstract() || metadata.isInterface()));

        //        return super.isCandidateComponent(beanDefinition);
    }
}
