package com.uni.demo;

public class ThreadDemo {


    private static final ThreadLocal<String> THREAD_LOCAL =
            ThreadLocal.withInitial(()->Thread.currentThread().getName());

    public static void main(String[] args) {
        //从 threadlocal获取本地缓存变量值
        System.out.println(THREAD_LOCAL.get());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> System.out.println("threadName:" + THREAD_LOCAL.get()),"thread-"+i).start();
        }




    }


}
