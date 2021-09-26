package com.example.sampledemo.jvm.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName DirectMemoryOOM.java
 * @Description 使用 unsafe 魔法类 分配本机内存
 *              VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 *              关于unsafe 魔法类的详细介绍：https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
 * @createTime 2021年09月24日 13:59
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }


}
