package com.itheima.service;


import com.itheima.domain.User;

import java.util.List;

public interface UserService {
    List<User>queryUserList();

    void saveUser( User user);
}
