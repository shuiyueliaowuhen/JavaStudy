package com.uni.demo.lock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class JvmLock {

    public void createOrder1(String orderId){
        //可以，性能差
        //这样，所有的线程都只能用一把锁
        synchronized (this){
            BusinessService.doService();
        }

    }

    public void createOrder2(String orderId){
        //有问题
        //sync比较的不是值而是对象
        //所以如果是一样的orderId，但是是不同线程进来，就是不同的锁
        synchronized (orderId){
            BusinessService.doService();
        }

    }

    public void createOrder3(String orderId){
        /**
         * 不可以，虽然解决了2的问题，极限情况会出问题
         *
         * jdk 1.6版本 放方法区，方法区属于永久代，数据多了就内存溢出了
         * 之后放堆里面，一般用锁就是应对高并发，这样会频繁的gc，stw ，触发full gc 清空数据也会有问题
         *
         * 性能也会差，因为默认string.intern是jni调用了c++接口，常量池是类似于hashmap的存在
         * 默认大小是1009（jdk8是60013），所以当数据量越大，hash冲突越严重，链表越长
         */
        synchronized (orderId.intern()){
            BusinessService.doService();
        }

    }


    //线程安全的map
    private Map<String,ReentrantLock> muteKey = new ConcurrentHashMap<>();

    public void createOrder4(String oderId){
        ReentrantLock lock = null,lockCache;

        do{

            if (lock != null) {
                lock.unlock();
            }

            lock = muteKey.computeIfAbsent(oderId, k -> new ReentrantLock());
            lock.lock();

            lockCache = muteKey.get(oderId);

        }while (lockCache == null || lockCache != lock);

        //这个写法有问题，简单来说就是 取锁和解锁不在 一个原子操作中，有可能有个线程拿到数据了，但是正好被前面的删了
        //java.lang.IllegalMonitorStateException 解锁的时候会抛，大意是当前线程和持有锁的线程不是同一个
//        ReentrantLock lock = muteKey.computeIfAbsent(oderId, k -> new ReentrantLock());

        try {
            BusinessService.doService();
        } finally {
            if(lock.getQueueLength() == 0){
                muteKey.remove(oderId);
            }

            lock.unlock();

        }

    }


    public static void main(String[] args) throws Exception {
        JvmLock jvmLock = new JvmLock();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                jvmLock.createOrder4("1");
            } ).start();
        }

        Thread.sleep(5 * 10);

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                jvmLock.createOrder4("1");
            } ).start();
        }


    }









}
