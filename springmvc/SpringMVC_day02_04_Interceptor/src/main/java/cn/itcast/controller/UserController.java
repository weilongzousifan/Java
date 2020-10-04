package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年02月20日 10:08:00
 */

@Controller
@RequestMapping("/user")
public class UserController {

//    异常处理
    @RequestMapping("/testIntercceptor")
    public String testIntercceptor()  {
        System.out.println("testIntercceptor执行。。。");


        return "success";
    }
}
