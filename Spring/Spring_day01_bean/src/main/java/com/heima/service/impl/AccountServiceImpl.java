package com.heima.service.impl;

import com.heima.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {



    public AccountServiceImpl() {
    }

    public void  init(){
        System.out.println("对象初始化了。。。");
    }

    public void saveAccount1() {

        System.out.println("Service 保存账户");
    }

    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}
