package com.holddie.springboot.mybatis.common.utils;

import java.util.Calendar;

/**
 * 日期工具类
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 17:47
 */
public class DateUtil {

    /**
     * 获取年份
     * @return 年份
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/18 17:48
     */
    public static int getYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     * @return 月份
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/18 17:48
     */
    public static int getMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }
}
