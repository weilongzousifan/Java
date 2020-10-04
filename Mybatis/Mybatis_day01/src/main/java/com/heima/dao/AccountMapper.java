package com.heima.dao;

import com.heima.domain.Account;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountMapper.java
 * @Description TODO
 * @createTime 2020年01月11日 08:56:00
 */
public interface AccountMapper {

//    查询所有账户
    List<Account> findAll();
}
