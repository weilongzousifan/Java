package com.itheima;

import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AopTest.java
 * @Description TODO
 * @createTime 2020年02月15日 16:29:00
 */

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        AccountService as=(AccountService)ac.getBean("accountService");
        as.saveAccount();
        as.updateAccount(5);
    }
}
