package com.ash.util.demo.proxy.strategy.demo1;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName StrategyFactory.java
 * @Description 策略工厂
 * @createTime 2021年07月23日 11:14
 */
public class StrategyFactory {

    public static PayStrategy getStrategy(ClassEnum classEnum) throws Exception {
        String className = classEnum.getClassName();
        return (PayStrategy) Class.forName(className).newInstance();
    }


}
