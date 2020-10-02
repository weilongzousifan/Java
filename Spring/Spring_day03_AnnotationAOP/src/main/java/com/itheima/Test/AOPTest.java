package com.itheima.Test;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AOPTest.java
 * @Description TODO
 * @createTime 2020年02月15日 20:07:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:bean.xml")
public class AOPTest {

    @Autowired
    private AccountService as;

    @Test
    public void testSave(){
        as.saveAccount();
    }
  /* public static void main(String[] args) {
       //1.获取容器
       ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
       //2.获取对象
       AccountService as = (AccountService)ac.getBean("accountService");
       //3.执行方法
       as.saveAccount();
   }*/
}
