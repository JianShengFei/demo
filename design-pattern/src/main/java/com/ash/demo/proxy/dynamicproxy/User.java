package com.ash.demo.proxy.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName RealSubject.java
 * @Description 真实对象
 * @createTime 2021年03月08日 17:08:00
 */
@Slf4j
public class User implements Buy {

    @Override
    public void buyMac() {
        System.out.println("购买一台MAC电脑");
    }
}
