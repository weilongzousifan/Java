package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "findAll",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findAll(){
        List<User> users = userService.queryUserList();
        return users;
    }

    @RequestMapping(value = "/find",method = RequestMethod.GET)
    @ResponseBody
    public String find(){
        return "hello";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody User user){
        String name = user.getName();
        String username = user.getUsername();
        String password = user.getPassword();
        userService.saveUser(user);
    }
}
