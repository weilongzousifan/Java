package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description TODO
 * @createTime 2020年02月19日 10:00:00
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /*返回值String*/
     @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user=new User();
        user.setUsername("灰太狼");
        user.setPassword("123");
        user.setAge(26);
//        将数据传入到 model中
        model.addAttribute("user",user);
        return "success";
    }

    /*无返回值String
    * 请求转发，一次请求，不需要写项目路径，可以跳转/WEB-INF/pages/目录下
    *
    * 需要特别注意：请求转发不走视图解析器，必须要全路径,
    *还有：请求转发后面如果还有代码的话，会继续执行，如果不想执行，直接return
    *
    *
    * 重定向，两次请求，需要写项目路径，不能跳转到/WEB-INF/pages/目录下
    * 获取项目路径：request.getContextPath()
    * */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");

//        请求转发

//         手动写转发的话，就不会调用SpringMVC.xml中的视图解析器，程序转发的后面如果有代码，程序还会继续执行
//		如果不想程序继续执行的话，可以直接在后面写：return
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);



//        重定向
//        重定向等于重新发了一次新的请求，直接发的请求不能直接请求/WEB-INF/pages/目录下的文件的，但转发没问题
//        response.sendRedirect(request.getContextPath()+"/index.jsp");


        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
//        直接进行相应：直接发请求，控制台直接通过输出流直接将数据响应给浏览器
        response.getWriter().print("灰太狼大王万岁，万岁万岁!!!");

        return ;
    }

    /*返回值ModelAndView
    *
    * ModelAndView的两个常用的方法
    *mv.addObject：设置数据
    *mv.setViewName：跳转到指定页面
    *
    * */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(ModelAndView mv){
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user=new User();
        user.setUsername("灰太狼");
        user.setPassword("123");
        user.setAge(26);
//        将数据传入到 mv中
        mv.addObject("user",user);

//        跳转到指定页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向，首先要明确一点，无法使用视图解析器的【很少用】
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");

        // 请求的转发
//         return "forward:/WEB-INF/pages/success.jsp";

        // 重定向 固定写法  这里不用再加项目名了，因为底层已经加过了
        return "redirect:/index.jsp";
    }


    /*发送异步请求*/
    @RequestMapping(value = "/testAjax",method = RequestMethod.POST)
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        System.out.println(" user:" +user);
        //作响应， 模拟从数据库中查询出User对象
        user.setUsername("灰太狼大王");
        user.setPassword("123123");
        user.setAge(26);

//        作响应
/*客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中，
使用@ResponseBody注解，SpringMVC框架会自动的将获取到的Json数据封装到JavaBean中，
特别需要注意的：data的格式一定要和JavaBean的属性对应*/
        return user;
    }
}
