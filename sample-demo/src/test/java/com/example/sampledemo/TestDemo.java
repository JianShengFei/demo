package com.example.sampledemo;

import org.junit.jupiter.api.Test;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName TestDemo.java
 * @Description 测试 一些简单的 demo
 * @createTime 2021年09月26日 11:07
 */
public class TestDemo {

    @Test
    public void test01() {

        int a = 1;
        int b = 2;
        int c = 3;

        if(a == 1) {
            System.out.println("1");
        } else if(b == 2) {
            System.out.println("2");
        } else if(c == 3) {
            System.out.println("3");
        }

    }

}
