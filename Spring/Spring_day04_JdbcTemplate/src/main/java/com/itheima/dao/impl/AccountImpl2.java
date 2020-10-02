package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountImpl.java
 * @Description TODO
 * @createTime 2020年02月16日 10:44:00
 *
 * 持久层AccountDao的实现类
 */
public class AccountImpl2 extends JdbcDaoSupport implements AccountDao {

    public Account findAccountByID(Integer accountId) {

        //super.getJdbcTemplate():调用父类的JdbcTemplate,
        List<Account>accounts= super.getJdbcTemplate().query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account>accounts=super.getJdbcTemplate().query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1)
            throw new RuntimeException("结果不唯一");
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set money=?,name=? where id=?",account.getMoney(),account.getName(),account.getId());
    }
}
