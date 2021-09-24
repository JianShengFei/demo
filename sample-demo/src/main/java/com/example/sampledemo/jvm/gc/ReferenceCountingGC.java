package com.example.sampledemo.jvm.gc;

import org.junit.jupiter.api.Test;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName ReferenceCountingGC.java
 * @Description 引用计数算法的缺陷
 * @createTime 2021年09月24日 14:51
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int _1MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否有回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    @Test
    public void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        // 假设在这行发生GC，objA和objB是否能被回收？
        System.gc();
    }


}
