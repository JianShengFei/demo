package com.example.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadPoolTest
 * @Description 线程池的基本使用
 * @Author jianshengfei
 * @Date 2021/7/19 23:53
 */
public class ThreadPoolTest {


    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Task());
        }
        threadPool.shutdown();
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始执行任务");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "执行完成");
        }
    }

}
