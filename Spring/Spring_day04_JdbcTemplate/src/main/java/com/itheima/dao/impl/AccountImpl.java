package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
public class AccountImpl implements AccountDao {

    //这里是 将JdbcTemplate交给spring创建，在bean.xml做相关的配置即可
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public Account findAccountByID(Integer accountId) {
        List<Account>accounts= jt.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account>accounts=jt.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1)
            throw new RuntimeException("结果不唯一");
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
        jt.update("update account set money=?,name=? where id=?",account.getMoney(),account.getName(),account.getId());
    }
}
