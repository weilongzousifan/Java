package com.heima.dao;

import com.heima.domian.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

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
    @Select("select * from account")
//    配置一对一数据查询
    /*property:实体类的属性    column：数据库中表字段
    @Result(property = "user", 【实体类的属性】
            column = "UID",       【select所需要的参数】
    one =@One(  【配置一对一映射】
    select ="com.heima.dao.UserMapper.findUserById", 【查询用户的唯一标识  名称空间namespace.方法名】
    fetchType = FetchType.EAGER) 【加载方式，lazy：延迟   Eager：立即  default：默认】
    )


    */
    @Results(id="Account_User",value = {
            @Result(id=true,property = "ID",column = "ID"),
            @Result(property = "UID",column = "UID"),
            @Result(property = "MONEY",column = "MONEY"),
            @Result(property = "user",column = "UID",
            one =@One(select ="com.heima.dao.UserMapper.findUserById",fetchType = FetchType.EAGER)),
    })
    List<Account> findAll();

//    根据id查询所有的账户
    @Select("select * from account where uid=#{uid}")
    List<Account>findAllAccount(Integer uid);
}
