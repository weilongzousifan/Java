package com.heima.dao.impl;

import com.heima.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public  void saveAccount(){

        System.out.println("Dao保存了账户");
    }
}
