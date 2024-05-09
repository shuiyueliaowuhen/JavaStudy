package com.uni.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class parallel {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }


        List<Integer> collect = list.stream().parallel().map(e -> e + 1).collect(Collectors.toList());

        System.out.println(collect.size());


    }



}
