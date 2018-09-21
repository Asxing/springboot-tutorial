package com.holddie.boot.sourcecode.enable;

import java.lang.annotation.*;

/**
 * 扫描注解
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 9:51
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLogScanner {

}
