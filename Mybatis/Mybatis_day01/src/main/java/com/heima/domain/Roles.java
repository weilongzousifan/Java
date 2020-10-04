package com.heima.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Roles.java
 * @Description TODO
 * @createTime 2020年01月11日 15:12:00
 */
public class Roles implements Serializable {
    private Integer ID;
    private  String roleName;
    private  String roleDesc;

//    配置一对多的映射
    private List<Users> users;

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "ID=" + ID +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }
}
