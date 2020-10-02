package com.itheima.proxy;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IProducer.java
 * @Description TODO
 * @createTime 2020年02月14日 18:01:00
 */
public interface IProducer {

//    卖产品
    public void saleProduct(Float money);

//    售后服务
    public void afterService(Float money);
}
