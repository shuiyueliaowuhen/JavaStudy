package com.uni.demo.create.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();
        l1.add("1");
        List<String> l2 = new ArrayList<>();
        l2.add("2");
        List<List<String>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);


        final List<String> collect = list.stream().flatMap(e -> e.stream()).collect(Collectors.toList());
        System.out.println(collect);


    }


}
