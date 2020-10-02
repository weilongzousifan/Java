package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TransactionConfig.java
 * @Description TODO
 * @createTime 2020年02月17日 09:55:00
 *
 * 和事务相关的配置类
 */
public class TransactionConfig {

    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
