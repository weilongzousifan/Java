package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountServiceImpl.java
 * @Description TODO
 * @createTime 2020年02月15日 16:08:00
 *
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("保存账户");
//        int s= 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("更新账户"+i);
    }

    public int deleteAccount() {
        System.out.println("删除账户");
        return 0;
    }
}
