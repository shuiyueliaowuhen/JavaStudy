package com.uni.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadException {




    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 4, 2L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(6));
        // 打印当前线程
        System.out.println(Thread.currentThread().getName());

        List<Future<String>> futureList = new ArrayList<>();
        // submit提交任务
        for (int i = 0; i < 10; i++) {
            Future<String> future = threadPoolExecutor.submit(new RunTask2());
            futureList.add(future);
        }
        // 获取返回值，会获取线程池中抛出的异常
        for (Future<String> future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("catch exception in main thread");
            }
        }
    }
}

class RunTask2 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("子线程");
        int a = 1 / 0; // 抛异常
        System.out.println("子线程。。。");
        return "hello";
    }

}
