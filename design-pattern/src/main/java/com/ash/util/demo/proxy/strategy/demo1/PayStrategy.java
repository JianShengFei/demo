package com.ash.util.demo.proxy.strategy.demo1;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName PayStrategy.java
 * @Description 策略顶层接口定义
 * @createTime 2021年07月23日 11:10
 */
public interface PayStrategy {

    /**
     * 支付
     * @param total
     */
    void pay(double total);

}
