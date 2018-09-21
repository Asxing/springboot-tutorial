package com.holddie.boot.sourcecode.enable;

/**
 * Service
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 14:02
 */
@MyLogScanner
public interface MyLogService {

    @MyLog(log = "logStart")
    public void logStart(String log);

    @MyLog(log = "logEnd")
    public String logEnd(String log);

}
