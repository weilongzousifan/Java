package com.itheima.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author WBH
 * @date 2020/4/25 21:52
 */
@Data
@TableName("tb_admin")
public class Administrator implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private String gender;

    private String privateSalt; //私有盐，用户密码加密

    private String tel;

    private String userStatus;

    @TableField(exist = false)
    private List<Role> roleList;
}
