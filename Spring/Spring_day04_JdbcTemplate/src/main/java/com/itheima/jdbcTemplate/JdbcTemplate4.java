package com.itheima.jdbcTemplate;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JdbcTemplate4.java
 * @Description TODO
 * @createTime 2020年02月16日 11:10:00
 *
 *JdbcTemplate在Dao层的基本用法
 */
public class JdbcTemplate4 {
    public static void main(String[] args) {
//        获取容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao=(AccountDao)ac.getBean("accountDao");
//        根据用户ID查询账户
        Account accountByID = accountDao.findAccountByID(8);
        System.out.println(accountByID);

//        根据用户名称查询账户
        Account accountByName = accountDao.findAccountByName("猪小明");
        System.out.println(accountByName);

//        更新账户
        Account account=new Account();
        account.setId(4);
        account.setMoney(2136f);
        account.setName("闰土");
        accountDao.updateAccount(account);
    }
}
