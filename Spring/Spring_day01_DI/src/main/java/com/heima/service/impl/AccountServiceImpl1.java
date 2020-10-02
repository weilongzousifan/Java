package com.heima.service.impl;

import com.heima.service.IAccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl1 implements IAccountService {


    private String name;
    private Integer age;
    private Date birthday;

    public void setUserName(String name) {
        this.name = name;
    }

    public void setUserAge(Integer age) {
        this.age = age;
    }

    public void setUserBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount1() {

        System.out.println("Service 保存账户....."+name+age+birthday);
    }

}
