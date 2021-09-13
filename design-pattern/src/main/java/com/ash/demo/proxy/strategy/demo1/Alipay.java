package com.ash.demo.proxy.strategy.demo1;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName Alipay.java
 * @Description 阿里支付
 * @createTime 2021年07月23日 11:11
 */
public class Alipay implements PayStrategy {
    @Override
    public void pay(double total) {
        System.out.println("pay with alipay: " + total);
    }
}
