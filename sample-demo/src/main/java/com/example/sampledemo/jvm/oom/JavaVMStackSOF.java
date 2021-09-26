package com.example.sampledemo.jvm.oom;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName JavaVMStackSOF.java
 * @Description StackOverflowError 实验测试
 * @createTime 2021年09月23日 16:46
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}
