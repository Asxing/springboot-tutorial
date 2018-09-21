package com.holddie.boot.sourcecode.enable;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 14:07
 */
@Slf4j
@Service
public class MyLogServiceImpl implements MyLogService {
    @Override
    public void logStart(String loginfo) {
        log.info("log 信息 ：" + loginfo);
    }

    @Override
    public String logEnd(String log) {
        return log;
    }
}
