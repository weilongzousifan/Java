package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * thymeleaf页面跳转
 */
@Controller
@RequestMapping("/page/")
public class PageController {

    @RequestMapping("toLogin")
    public String toLogin(Model model){//转发的时候带数据，可以使用model
        model.addAttribute("errMessage","开始登陆");
        return "login"; //默认转发到classpath下面的templates下面的名为login 后缀html的
    }
    @RequestMapping("toDenied")
    public String toDenied(){
        return "denied";
    }
}
