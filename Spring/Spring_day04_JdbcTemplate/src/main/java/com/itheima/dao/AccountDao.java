package com.itheima.dao;

import com.itheima.domain.Account;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountDao.java
 * @Description TODO
 * @createTime 2020年02月16日 10:40:00
 *
 * 持久层的Account接口
 */
public interface AccountDao {

    //根据ID查询账户
    Account findAccountByID(Integer accountId);

//    根据用户名称查询账户
    Account findAccountByName(String accountName);

//更新账户
    void updateAccount(Account account);
}
