package com.example.threads.dmeo03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @Description 通过ReentrantLock解决原子问题
 * @ClassName Thread.java
 * @createTime 2021年04月29日 16:23
 */
public class LockThreadDemo {

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
            Thread thread = new Thread(() -> LockThreadDemo.updateCount());
        }
        Thread.sleep(4000);

        System.out.println(count);
    }

    public static void updateCount(){
        lock.lock();
        try {
            // 这里休眠一下, 只是需要让各个线程处理数据出现一个时间差
            Thread.sleep(1);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        count++;
    }

}
