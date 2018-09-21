package com.holddie.boot.sourcecode.enable;


import java.lang.reflect.Method;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 11:28
 */
public class DefaultLogSupport implements LogSupport {
    @Override
    public Object invoke(Method method, Object[] args) {
        MyLog myLog = method.getAnnotation(MyLog.class);

        // 没有数据返回
        if (null == myLog) {
            return null;
        }
        String log = myLog.log();
        if (null != args && args.length == 1) {
            log += ":" + args[0];
        }
        System.out.println(log);
        if (method.getReturnType() == String.class || method.getReturnType() == Object.class) {
            return log;
        }
        return null;
    }
}
