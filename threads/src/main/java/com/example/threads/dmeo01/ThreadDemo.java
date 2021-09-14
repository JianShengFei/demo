package com.example.threads.dmeo01;

import com.example.threads.dmeo03.LockThreadDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @Description 一个简单的代码 引发原子问题思考
 * @ClassName Thread.java
 * @createTime 2021年04月29日 16:23
 */
public class ThreadDemo {

    /**
     * 创建的线程数
     */
    private static int numThreads = 1000;
    /**
     * 共享资源
     */
    private static int count = 0;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < numThreads; i++) {
            new Thread(()-> LockThreadDemo.updateCount()).start();
        }
        Thread.sleep(4000);

        System.out.println(count);
    }

    public static void updateCount(){
        try {
            // 这里休眠一下, 只是需要让各个线程处理数据出现一个时间差
            Thread.sleep(1);
        }catch (Exception e) {
            e.printStackTrace();
        }
        count++;
    }

}
