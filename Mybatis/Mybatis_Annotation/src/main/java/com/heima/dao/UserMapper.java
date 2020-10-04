package com.heima.dao;


import com.heima.domian.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2020年01月06日 21:00:00
 */
//开启二级缓存的注解配置
@CacheNamespace(blocking = true)
public interface UserMapper {
    /*查询所有用户*/
    @Select("select * from user")
//    配置实体类属性和数据库表字段不一致的映射
    @Results( id ="biao", value = {
          @Result(id=true,property = "user_id",column ="id" ),
          @Result(property = "user_username",column ="username" ),
          @Result(property = "user_birthday",column ="birthday" ),
          @Result(property = "user_sex",column ="sex" ),
          @Result(property = "user_address",column ="address" ),
          @Result(property = "accounts" ,column = "id",many = @Many(
                  select = "com.heima.dao.AccountMapper.findAllAccount",fetchType = FetchType.DEFAULT))
    })
    List<User>findAll();


    @Select("select *from user where id=#{id}")
//    正规写法，多个值可以加逗号分隔，默认情况下可以省略value和大括号
    @ResultMap(value={"biao"})
    User findUserById(Integer id);
}
