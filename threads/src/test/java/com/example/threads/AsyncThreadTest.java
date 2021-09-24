package com.example.threads;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author jianshengfei
 * @version 1.0.0
 * @ClassName AsynThreadTest.java
 * @Description 异步编程-CompletableFuture 使用案例
 * @createTime 2021年09月17日 14:11
 */
@Slf4j
public class AsyncThreadTest {

    List<Integer> result = new ArrayList<>();

    @Test
    public void test01() throws InterruptedException {

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
             integers.add(i+1);
        }

        ExecutorService executorService = ExecutorBuilder.create().setWorkQueue(new LinkedBlockingQueue<>())
                .setCorePoolSize(10).setMaxPoolSize(10).build();


        CompletableFuture[] completableFutures = integers.stream().map(integer -> CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.add(integer);
        }, executorService)).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
        System.out.println(JSONUtil.toJsonStr(result));
    }

    @Test
    public void test02() {
        System.out.println("");
    }

}
