package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SpringConfiguration.java
 * @Description TODO
 * @createTime 2020年02月17日 09:28:00
 *
 * 这是配置类,有@Import注解的类为主配置类
 *
 */
@Configuration
@ComponentScan("com.itheima")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("jdbcConfig.properties")
//开启注解事务的支持
@EnableTransactionManagement
public class SpringConfiguration {
}
