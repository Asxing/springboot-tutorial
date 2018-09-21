package com.holddie.boot.sourcecode;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 核心类
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/20 10:23
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "myconfig")
public class MyBean implements InitializingBean, IMyBean {
    String customValue;
    String name;
    String age;
    String desc;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.error("======> afterPropertiesSet");
    }
}
