package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ParamController.java
 * @Description TODO
 * @createTime 2020年02月18日 15:30:00
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /*基本类型的参数绑定*/
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("基本类型的参数绑定。。。");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }

    /*其它bean类型的参数绑定，bean类型中包含其它bean类型的引入*/
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("基本类型的参数绑定。。。");
        System.out.println("账户Account："+account);
        return "success";
    }

    /*集合类型的参数绑定*/
    @RequestMapping("/saveAccountList")
    public String saveAccountList(Account account){
        System.out.println("基本类型的参数绑定。。。");
        System.out.println("账户Account："+account);
        return "success";
    }


    /*自定义的类型转换器*/
    @RequestMapping("/saveUserDate")
    public String saveUserDate(User user){
        System.out.println("基本类型的参数绑定。。。");
        System.out.println("用户User："+user);
        return "success";
    }

    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了...");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }

}
