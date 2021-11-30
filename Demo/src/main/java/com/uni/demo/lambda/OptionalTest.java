package com.uni.demo.lambda;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        System.out.println( Optional.ofNullable(getPersion()));
    }


    public static Persion getPersion(){
        return null;
    }
}
