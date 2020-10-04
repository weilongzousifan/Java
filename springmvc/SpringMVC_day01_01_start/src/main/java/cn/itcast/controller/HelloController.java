package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName HelloController.java
 * @Description TODO
 * @createTime 2020年02月18日 09:47:00
 */
@Controller
@RequestMapping("/user")
public class HelloController {

    /*path属性和value属性效果一样，当只有一个值时，value可以省略不写
    @RequestMapping：请求映射，可以放在方法上，也可以放在类上，放在类上表示一级目录
    放在方法上表示二级目录*/
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("SpringMVC入门");
        return "success";
    }

    /**
     * RequestMapping注解
     * @return
     */
    @RequestMapping(value="/testRequestMapping",params = {"username=heihei"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }


}
