package com.itheima.cglib;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName Producer.java
 * @Description TODO
 * @createTime 2020年02月14日 18:31:00
 *
 * 生产者
 */
public class Producer {

    //    卖产品
    public void saleProduct(Float money) {
        System.out.println("卖产品，共获得："+money);
    }

    //    售后服务
    public void afterService(Float money) {
        System.out.println("售后服务，共获得："+money);
    }
}
