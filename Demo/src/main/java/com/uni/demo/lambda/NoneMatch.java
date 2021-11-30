package com.uni.demo.lambda;

import java.math.BigDecimal;

public class NoneMatch {


    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        System.out.println(list.stream().noneMatch(e -> e.equals("c") ));


//        String s = "a/1";
//        System.out.println(s.split("/").length);




        BigDecimal divide = new BigDecimal("2240400.00").divide(new BigDecimal(10000));
        System.out.println(divide);
        System.out.println(  divide.compareTo(new BigDecimal("224.04")));

    }

}
