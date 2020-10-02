package com.heima.ui;

import com.heima.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//       获取Spring的IOC核心容器，并根据id获取对象
//        读取配置文件
//        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
//        默认构造方法
        //IAccountService accountService=(IAccountService)cpxa.getBean("accountServiceImpl");

//        类中的普通方法
        //IAccountService accountService=(IAccountService)ac.getBean("beanFactory_method");

//          类中的静态方法
//        IAccountService accountService1=(IAccountService)cpxa.getBean("beanFactory_Static_method");
        IAccountService accountService2=(IAccountService)ac.getBean("beanFactory_Static_method");
//        System.out.println(accountService1==accountService2);
        accountService2.saveAccount1();

//        手动关闭容器
        ac.close();
    }
}
