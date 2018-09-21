package com.holddie.boot.sourcecode;

/**
 * 自定义接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/21 9:27
 */
public interface IMyBean {
    /**
     * 获取自定value
     * @return String
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/8/21 9:29
     */
    String getCustomValue();

    /**
     * 设置自定义值
     * @param customValue 参数值
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/8/21 9:29
     */
    void setCustomValue(String customValue);
}
