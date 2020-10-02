package com.itheima.service;

import com.itheima.pojo.Administrator;

import java.util.List;
import java.util.Set;

public interface AdminService {
    List<Administrator> findAll();

    void deleteById(Integer id);

    Administrator findUserByUsername(String username);

    Set<String> findRolesByUsername(String username);

    Set<String> findPermissionsByUsername(String username);
}
