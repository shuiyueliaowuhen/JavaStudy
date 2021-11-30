package com.uni.demo.lambda;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        test(() ->so());
    }

    static String so(){
        System.out.println("so方法执行");
        return "supplier";
    }

    static void test(Supplier<String> supplier){
        System.out.println("自己的逻辑");
        String s = supplier.get();
        System.out.println("获取到 so方法的值："+s);

    }



}
