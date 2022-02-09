package com.uni.demo.lock;

public class BusinessService {

    public static void doService(){
        try {
            System.out.println("开始");
            Thread.sleep(10);
            System.out.println("结束");
        }catch (Exception e){

        }

    }



}
