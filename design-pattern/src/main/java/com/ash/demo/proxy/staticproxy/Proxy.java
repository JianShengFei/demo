package com.ash.demo.proxy.staticproxy;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName Proxy.java
 * @Description 代理类, 实现真实对象需要做的事，并在原有基础上增加附加方法
 * @createTime 2021年03月08日 17:10:00
 */
public class Proxy implements Buy {

    private User user;

    public Proxy(User user) {
        this.user = user;
    }

    @Override
    public void buyMac() {
        System.out.println("代理去到美国...");
        user.buyMac();
        this.WrapMac();
    }

    private void WrapMac(){
        System.out.println("用盒子包装MAC");
    }

}
