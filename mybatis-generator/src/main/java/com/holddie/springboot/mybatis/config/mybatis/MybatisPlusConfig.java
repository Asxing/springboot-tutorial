package com.holddie.springboot.mybatis.config.mybatis;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.boot.starter.ConfigurationCustomizer;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus插件配置
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 16:53
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/18 16:59
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor().setLocalPage(true);
    }

    /**
     * Puls 性能优化
     * @author HoldDie
     * @email HoldDie@163.com
     * @date 2018/5/20 16:11
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(1000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }


    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new MybatisPlusCustomizers();
    }

    class MybatisPlusCustomizers implements ConfigurationCustomizer {
        @Override
        public void customize(org.apache.ibatis.session.Configuration configuration) {
            configuration.setJdbcTypeForNull(JdbcType.NULL);
        }
    }

}
