package com.holddie.springboot.mybatis.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 17:56
 */
@Configuration
@EnableTransactionManagement
public class MultiDuridDataSource {
    // 第一数据源
    @Value("${spring.datasource.primary.url}")
    private String primaryUrl;
    @Value("${spring.datasource.primary.username}")
    private String primaryUsername;
    @Value("${spring.datasource.primary.password}")
    private String primaryPassword;
    @Value("${spring.datasource.primary.driver-class-name}")
    private String primaryDriver;

    // 第二数据源
    @Value("${spring.datasource.secondary.url}")
    private String slaveUrl;
    @Value("${spring.datasource.secondary.username}")
    private String slaveUsername;
    @Value("${spring.datasource.secondary.password}")
    private String slavePassword;
    @Value("${spring.datasource.secondary.driver-class-name}")
    private String slaveDriver;

    @Bean("dataSource")
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(primaryUrl);
        druidDataSource.setUsername(primaryUsername);
        druidDataSource.setPassword(primaryPassword);
        druidDataSource.setDriverClassName(primaryDriver);
        return druidDataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("slaveDataSource")
    public DataSource secondaryDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(slaveUrl);
        druidDataSource.setUsername(slaveUsername);
        druidDataSource.setPassword(slavePassword);
        druidDataSource.setDriverClassName(slaveDriver);
        return druidDataSource;
    }

    @Bean("slaveJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("slaveDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
