package com.ash.util.demo.proxy.strategy.demo1;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName WechatPay.java
 * @Description 微信支付
 * @createTime 2021年07月23日 11:12
 */
public class WechatPay implements PayStrategy {
    @Override
    public void pay(double total) {
        System.out.println("pay with wechat pay: " + total);
    }
}
