package com.heima.dao;

import com.heima.domain.Roles;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年01月06日 21:00:00
 */
public interface RolesMapper {
//    查询所有角色信息
    List<Roles> findAll();
}
