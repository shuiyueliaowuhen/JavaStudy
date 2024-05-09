package com.uni.demo;

import lombok.Data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Data
public class CountdownLatch2Test {

    private int i = 0;

    public static void concurrenceTest() {


        // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 100; i++) {
                executorService.submit( () -> {
                        try {
                            countDownLatch.await(); //一直阻塞当前线程，直到计时器的值为0,保证同时并发
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                });
                countDownLatch.countDown();
            }

            executorService.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        concurrenceTest();
    }

}
