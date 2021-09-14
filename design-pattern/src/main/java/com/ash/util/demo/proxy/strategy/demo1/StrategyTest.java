package com.ash.util.demo.proxy.strategy.demo1;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName StrategyTest.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年07月23日 11:16
 */
public class StrategyTest {

    public static void main(String[] args) throws Exception {


        PayStrategy strategy = StrategyFactory.getStrategy(ClassEnum.ALIPAY);
        strategy.pay(3);


    }


}
