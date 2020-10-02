package com.itheima.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
@Controller
@RequestMapping("/backend")
public class LoginController {

    @RequestMapping("login")
    public String login(@RequestParam String username,@RequestParam String password,Model model){
        try{
            // subject - securityManager - realm

            //核心流程：
            // 1.用户登录会看到login.html页面，
            // 2.输入用户名和密码会进入到后台进行判断【也就是当前页面：LoginController】
            //3.判断输入的用户名密码是否正确，在realm中的【认证中】进行判断


            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(username,password);
            subject.login(token);
            //return "redirect:/page/toSuccess";  重定向跳转
            return "success";
        }catch (UnknownAccountException e){
            e.printStackTrace();
            model.addAttribute("errMessage","用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("errMessage","密码错误");
            return "login";
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errMessage","系统错误");
            return "login";
        }
    }
}
