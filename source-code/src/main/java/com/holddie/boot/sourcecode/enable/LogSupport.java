package com.holddie.boot.sourcecode.enable;

import java.lang.reflect.Method;

/**
 * 日志接口方法
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 11:29
 */
public interface LogSupport {
    Object invoke(Method method, Object[] args);
}
