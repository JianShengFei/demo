package com.example.sampledemo.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName RuntimeConstantPoolOOM.java
 * @Description 方法区和运行时常量池溢出
 *              PermSize  MaxPermSize  在jdk8虚拟机中已经移除配置
 *              因为使用永久代来实现方法区不是个好主意, 很容易遇到内存溢出的问题.
 *              我们通常使用PermSize和MaxPermSize设置永久代的大小, 这个大小就决定了永久代的上限,
 *              但是我们不是总是知道应该设置为多大的, 如果使用默认值容易遇到OOM错误.
 * @createTime 2021年09月24日 10:40
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }

}
