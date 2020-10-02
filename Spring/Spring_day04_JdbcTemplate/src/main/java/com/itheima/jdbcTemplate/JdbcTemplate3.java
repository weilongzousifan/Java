package com.itheima.jdbcTemplate;

import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JdbcTemplate3.java
 * @Description TODO
 * @createTime 2020年02月16日 10:03:00
 *
 *JdbcTemplate的CRUD
 * 这只是测试的时候使用
 */
public class JdbcTemplate3 {
    public static void main(String[] args) {
//       获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        获取JdbcTemplate对象
        JdbcTemplate jt=(JdbcTemplate)ac.getBean("jdbcTemplate");

//        执行SQL操作

//        保存
        jt.update("insert into account(name,money)values (?,?)","陈翔",4567f);

//        更新
        jt.update("update account set name=? ,money=? where id=?","冷萌",888f,6);
//        删除
        jt.update("delete from account where id=?",5);

//          查询所有
        List<Account> accounts=jt.query("select * from account where money> ?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
        for (Account account : accounts) {
            System.out.println(account);
        }

//       查询一个
       List<Account>accounts1= jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),6);
        System.out.println(accounts1.isEmpty()?"没有此人":accounts1.get(0));


//        查询返回一行一列【使用聚合函数，但不加group by语句】
        Long count=jt.queryForObject("select count(*) from account where money>?",Long.class,1000f);
        System.out.println(count);
    }
}
