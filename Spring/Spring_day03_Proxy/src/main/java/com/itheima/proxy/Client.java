package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Client.java
 * @Description TODO
 * @createTime 2020年02月14日 18:06:00
 *
 * 买家
 */
public class Client {

    public static void main(String[] args) {
        //匿名内部类访问外部成员变量时，成员变量必须被final修饰
        final Producer producer=new Producer();

        /**
         * 动态代理：
         *  特点：字节码随用随创建，随用随加载
         *  作用：不修改源码的基础上对方法增强
         *
         *  分类：
         *      基于接口的动态代理
         *      基于子类的动态代理
         *
         *  基于接口的动态代理：
         *      涉及的类：Proxy
         *      提供者：JDK官方
         *
         *  如何创建代理对象：
         *      使用Proxy类中的newProxyInstance方法
         *
         *  创建代理对象的要求：
         *      被代理类最少实现一个接口，如果没有则不能使用
         *
         *  newProxyInstance方法的参数：
         *      ClassLoader：类加载器
         *          它是用于加载代理对象字节码的。和被代理对象使用相同的类加载器。固定写法。
         *      Class[]：字节码数组
         *          它是用于让代理对象和被代理对象有相同方法。固定写法。
         *      InvocationHandler：用于提供增强的代码
         *          它是让我们写如何代理。我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的。
         *          此接口的实现类都是谁用谁写【谁要对方法增强谁就来写】。
         */

//        producer.getClass()和Producer.class一个意思
        IProducer proxyProducer=(IProducer)Proxy.newProxyInstance(Producer.class.getClassLoader(),
                                Producer.class.getInterfaces(),
                                new InvocationHandler() {
            /**
             * 作用：执行被代理对象的任何接口方法都会经过该方法
             * 方法参数的含义
             * @param proxy   代理对象的引用   可以获取代理对象，但一般不用
             * @param method  当前执行的方法   可以理解为：被代理对象的方法，也就是要被增强的方法
             * @param args    当前执行方法所需的参数
             * @return        和被代理对象方法有相同的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //提供增强的代码

                Object returnValue=null;
//                获取执行方法所需参数  saleProduct方法只有一个参数  money
                Float money=(Float) args[0];
                //判断方法是不是卖产品
                if("saleProduct".equals(method.getName())){
//                    这里貌似是固定写法：method.invoke  要被增强的方法属于哪个类    执行该方法所需的参数
                    returnValue=method.invoke(producer,money*0.8f);

                }
                return returnValue;
            }

        });

        proxyProducer.saleProduct(1000f);
    }
}
