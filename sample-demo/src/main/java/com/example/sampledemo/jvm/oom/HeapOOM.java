package com.example.sampledemo.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName HeapOOM.java
 * @Description OOM test
 * @createTime 2021年09月23日 15:51
 */
public class HeapOOM {


    public static class OOMObject {

    }

    public static void main(String[] args) {
        /*
            -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
            大概在 第160065次 抛出堆内存溢出
         */
        System.out.println("OOM Test...");
        List<OOMObject> list = new ArrayList<>();
        int i = 1;
        while (true) {
            OOMObject o = new OOMObject();
            list.add(o);
            System.out.println(i);
            i++;
        }


    }

}
