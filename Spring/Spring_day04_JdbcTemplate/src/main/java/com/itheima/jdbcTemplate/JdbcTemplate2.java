package com.itheima.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JdbcTemplate1.java
 * @Description TODO
 * @createTime 2020年02月16日 09:39:00
 *
 *JdbcTemplat在spring IOC中的的使用
 */
public class JdbcTemplate2 {
    public static void main(String[] args) {
//        获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        获取JdbcTemplate对象
        JdbcTemplate jt=(JdbcTemplate)ac.getBean("jdbcTemplate");
//        执行SQL语句
        jt.execute("insert into account(name,money)values('猪小明',666)");
    }
}
