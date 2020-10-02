package com.itheima.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_storage")
public class Storage implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
}
