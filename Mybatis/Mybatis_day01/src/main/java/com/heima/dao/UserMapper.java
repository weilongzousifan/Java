package com.heima.dao;

import com.heima.domain.QueryVo;
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

//    添加用户
   void AddUser(User user);

//   更新用户
    void updateUser(User user);

//    删除用户
    void deleteUser(Integer id);

//    根据id查询用户
    User selectUserById(Integer userId);

//    根据姓名模糊查询用户
    List<User> selectUserByName(String username);

//    获取所有的用户数量
    Integer findUserAll();

    //根据姓名模糊查询用户
    List<User>findAllUerByName(QueryVo vo);

//    根据条件查询用户
    List<User> findUserNameByCondition(User user);

//    根据queryvo提供的id集合查询用户
    List<User>findAllUserByIds(QueryVo vo);

//    查询所有用户的所用账户
    List<User>findAllUserAccount();
}
