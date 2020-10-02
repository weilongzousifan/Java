package com.itheima.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.itheima.pojo.Administrator;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 *
 */
@Repository
//@Mapper
public interface AdministratorMapper extends BaseMapper<Administrator> {

    @Select("select distinct r.code" +
            " from tb_role r,tb_admin u,tb_admin_role ur" +
            " where r.id = ur.role_id and u.id = ur.admin_id and u.username = #{username}")
    Set<String> findRolesByUsername(String username);

    @Select("select distinct p.code " +
            "from tb_role r,tb_admin u,tb_admin_role ur,tb_role_perm rp,tb_permission p " +
            "where r.id = ur.role_id and u.id = ur.admin_id and rp.role_id = r.id and rp.perm_id = p.id " +
            "and u.username = #{username}")
    Set<String> findPermissionsByUsername(String username);
}
