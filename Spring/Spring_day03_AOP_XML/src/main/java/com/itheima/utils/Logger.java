package com.itheima.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Logger.java
 * @Description TODO
 * @createTime 2020年02月15日 16:11:00
 *
 *用于记录日志的工具类，里面提供了公共的代码
 */
public class Logger {

//    打印日志：计划让其在切入点方法执行之前 执行【切入点方法就是业务层的方法】
    /*public void printLogger(){
        System.out.println("打印日志");
    }*/

    /**
     * 前置通知
     */
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     *      简单来说 可以通过配置的方式实现四种通知，也可以通过代码的方式手动实现四种通知
     */

    public Object aroundPrintlog(ProceedingJoinPoint prj){

        Object rtvalue=null;
        try {
//            得到方法执行所需要的参数
            Object[] args = prj.getArgs();
            System.out.println("Logger类中的aroundPrintlog方法开始记录日志了。。。+前置");
//            明确调用业务层方法【切入方法】
           rtvalue= prj.proceed(args);
            System.out.println("Logger类中的aroundPrintlog方法开始记录日志了。。。+后置");
        } catch (Throwable t) {//该异常必须写Throwable   Exception拦不住它
            t.printStackTrace();
            System.out.println("Logger类中的aroundPrintlog方法开始记录日志了。。。+异常");
        } finally {
            System.out.println("Logger类中的aroundPrintlog方法开始记录日志了。。。+最终");
        }
        return rtvalue;

    }
}
