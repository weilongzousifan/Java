package com.heima.dao;


import com.heima.domain.User;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年01月06日 21:00:00
 */
public interface UserMapper {
    /*查询所有用户*/
    List<User>findAll();


}
