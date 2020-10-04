package cn.itcast.controller;

import cn.itcast.exception.SysException;
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
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行。。。");

//        快捷键：Ctrl+Alt+t
        try {
            // 模拟异常
            int a=1/0;
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            // 抛出自定义异常信息
           throw new SysException("分母不能为零。。。");
        }
//        int a=1/0;
        return "success";
    }
}
