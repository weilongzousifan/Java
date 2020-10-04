package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SysExceptionResolver.java
 * @Description TODO
 * @createTime 2020年02月20日 10:21:00
 */
//自定义的异常处理器  必须实现HandlerExceptionResolve接口
public class SysExceptionResolver implements HandlerExceptionResolver {

//  ex：抛出的自定义异常类的对象，ex就可以当做异常对象拿到提示信息
//    获取异常对象
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        SysException sysException=null;
//        判断ex是不是属于SysException的类型
        if(ex instanceof SysException){
           sysException=(SysException)ex;
        }else {
            sysException=new SysException("系统长在维护中。。。。");
        }
       /*返回值：ModelAndView
       *两个常用的方法：
       * 赋值  addObject
       * 跳转到指定界面： setViewName
       * */

       ModelAndView mv=new ModelAndView();
//       赋值
       mv.addObject("msg",sysException.getSysMessage());
//      跳转到指定界面
        mv.setViewName("erro");
        return mv;
    }
}
