package com.uni.demo.lambda;

import java.util.ArrayList;
import java.util.List;

public class FlatMapTest {

    public static void main(String[] args) {

//        List<String> l1 = new ArrayList<>();
//        l1.add("1");
//        List<String> l2 = new ArrayList<>();
//        l2.add("2");
//        List<List<String>> list = new ArrayList<>();
//        list.add(l1);
//        list.add(l2);
//
//
//        final List<String> collect = list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
//        System.out.println(collect);

        List<Persion> list = new ArrayList<>();
        list.add(new Persion("1"));
        list.add(new Persion("1"));
        list.add(new Persion("2"));


    }


}
