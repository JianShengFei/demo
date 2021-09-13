package com.ash.util.demo.proxy.strategy.demo1;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName ClassEnum.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年07月23日 11:09
 */
public enum ClassEnum {

    ALIPAY("com.strategy.impl.Alipay"),
    WECHAT_PAY("com.strategy.impl.WechatPay");

    private String className;

    public String getClassName() {
        return className;
    }

    ClassEnum(String className) {
        this.className = className;
    }
}
