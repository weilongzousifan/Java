package com.itheima.controller;


import com.itheima.pojo.Administrator;
import com.itheima.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/all")
    public List<Administrator> findAll(){
        return adminService.findAll();
    }

    @RequestMapping("/del/{id}")
    @RequiresRoles("role_superman")
    public String delAdmin(@PathVariable("id")Integer id){

//        SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal() //获取用户信息
        adminService.deleteById(id);
        return "OK";
    }
}
