package com.heima.ui;

import com.heima.dao.IAccountDao;
import com.heima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//       获取Spring的IOC核心容器，并根据id获取对象
//        读取配置文件
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        IAccountDao accountDao=(IAccountDao)ac.getBean("accountDaoImpl");
        System.out.println("accountDao"+accountDao);
        accountDao.saveAccount();
        System.out.println("------------------------");
        IAccountService accountService=ac.getBean("accountServiceImpl",IAccountService.class);
        accountService.saveAccount1();
    }
}
