package com.heima.factory;

import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BeanFactory.java
 * @Description TODO
 * @createTime 2020年01月17日 10:54:00
 */
//模拟一个工厂类(该类存在于jar包中，无法通过修改源码的基础上修改构造函数)
public class BeanFactory {

    public IAccountService getIAccountService(){
        return  new AccountServiceImpl();
    }
}
