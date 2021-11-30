package com.uni.demo;

import lombok.Data;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

@Data
public class CountdownLatchTest {

    private int i = 0;

    public static void concurrenceTest() {
        /**
         * 模拟高并发情况代码
         */
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        CountdownLatchTest countdownLatchTest = new CountdownLatchTest();

        Predicate<Integer> isOuShu = (e) -> e%2 == 0;


        final CountDownLatch countDownLatch = new CountDownLatch(100); // 相当于计数器，当所有都准备好了，再一起执行，模仿多并发，保证并发量
        final CountDownLatch countDownLatch2 = new CountDownLatch(100); // 保证所有线程执行完了再打印atomicInteger的值
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        try {
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            countDownLatch.await(); //一直阻塞当前线程，直到计时器的值为0,保证同时并发
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //每个线程增加1000次，每次加1
                        for (int j = 0; j < 10; j++) {
//                            atomicInteger.incrementAndGet();
                            System.out.println( isOuShu.test(finalI +j) );
//                            countdownLatchTest.setI(countdownLatchTest.getI()+1);
                        }
                        countDownLatch2.countDown();
                    }
                });
                countDownLatch.countDown();
            }

            countDownLatch2.await();// 保证所有线程执行完
//            System.out.println(atomicInteger);
//            System.out.println(countdownLatchTest.i);
            executorService.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        concurrenceTest();
    }

}
