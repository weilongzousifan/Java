package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AnnoController.java
 * @Description TODO
 * @createTime 2020年02月18日 20:19:00
 *
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})   // 把msg=美美存入到session域对中
public class AnnoController {

    /*@RequestParam注解*/
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("name") String username){
        System.out.println("RequestParam正在执行");
        System.out.println("username:"+username);
        return "success";
    }

    /*@RequestBody注解

    *获取请求体内容
    * */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("RequestBody正在执行");
        System.out.println("body:"+body);
        return "success";
    }

    /*@PathVariable注解

     *获取URL中的占位符
     * */
    @RequestMapping("/testPathVariable/{uid}")
    public String testPathVariable(@PathVariable("uid") String id){
        System.out.println("PathVariable正在执行");
        System.out.println("id:"+id);
        return "success";
    }

    /*@RequestHeader注解

     *获取指定请求头的信息
     * */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept") String header){
        System.out.println("RequestHeader正在执行");
        System.out.println("header:"+header);
        return "success";
    }

    /*@CookieValue注解

     *获取指定Cookie的信息
     * */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
        System.out.println("RequestHeader正在执行");
        System.out.println("cookie:"+cookie);
        return "success";
    }

    /**
     * ModelAttribute注解
     * @return
     */
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟） 修饰的方法没有返回值
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * 该方法会先执行
     */
     @ModelAttribute
     public User showUser(String uname){
     System.out.println("showUser执行了...");
     // 通过用户查询数据库（模拟） 修饰的方法有返回值
     User user = new User();
     user.setUname(uname);
     user.setAge(20);
     user.setDate(new Date());
     return user;
     }

    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        //删除session中的值
        status.setComplete();
        return "success";
    }
}
