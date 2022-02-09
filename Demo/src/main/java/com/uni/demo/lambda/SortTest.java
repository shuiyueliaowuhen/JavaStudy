package com.uni.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTest {

    public static void main(String[] args) {
        List<Persion> list = new ArrayList<>();
        Persion persion1 = new Persion("1");
        Persion persion2 = new Persion("2");
//        list.add(persion2);
        list.add(persion1);
        list.add(persion2);
//        list = null;

//        Map<String, Persion> collect = list.stream().collect(Collectors.toMap(Persion::getId, t -> t));









//        System.out.println(list);
////        list.sort(Comparator.comparing(Persion::getId).reversed());
//        list.stream().sorted(Comparator.comparing(Persion::getId));
//
//        System.out.println(list);


    }
}
