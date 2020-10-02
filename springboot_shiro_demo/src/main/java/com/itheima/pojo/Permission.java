package com.itheima.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_permission")
public class Permission implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private String url;
//    private String permType;//0:资源菜单 1资源下的权限
}
