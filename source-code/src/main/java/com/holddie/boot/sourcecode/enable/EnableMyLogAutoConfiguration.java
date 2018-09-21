package com.holddie.boot.sourcecode.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自定义注解入口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 9:58
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import(MyLogAutoConfigurationRegistrar.class)
public @interface EnableMyLogAutoConfiguration {

    String basePackage() default "";

    // 设置代理类的实现，默认使用JDK动态代理
    Class<? extends AbstractMyLogFactoryBean> implClass() default MyLogFactoryBean.class;

}
