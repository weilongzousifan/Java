package com.itheima.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@TableName("tb_role")
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private String intro;

    @TableField(exist = false)
    private List<Permission> permissionList;
}
