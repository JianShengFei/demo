package com.example.threads.demo04;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Ash Jan
 * @version 1.0.0
 * @ClassName CallableDemo.java
 * @Description TODO 请标注类具体的用途
 * @createTime 2021年08月19日 14:47
 */
public class CallableDemo {

    private static volatile Integer i = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            i ++;
            return i;
        });

        Integer integer = completableFuture.get();
        System.out.println(integer);

    }





}
