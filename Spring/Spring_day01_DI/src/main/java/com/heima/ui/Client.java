package com.heima.ui;

import com.heima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//       获取Spring的IOC核心容器，并根据id获取对象
//        读取配置文件,获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");

//        根据id获取bean对象
//        默认构造方法
        /*IAccountService accountService=(IAccountService)ac.getBean("accountServiceImpl");
        accountService.saveAccount1();*/

        /*IAccountService accountService1=(IAccountService)ac.getBean("accountServiceImpl1");
        accountService1.saveAccount1();*/

        IAccountService accountService2=(IAccountService)ac.getBean("accountServiceImpl2");
        accountService2.saveAccount1();

    }
}
