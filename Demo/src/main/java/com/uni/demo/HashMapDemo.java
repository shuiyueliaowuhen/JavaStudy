package com.uni.demo;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<>(10);
        System.out.println(map.put("a",1));
        System.out.println(map.put("b",2));
        System.out.println(map.put("a",11));
        System.out.println(map.put("c",3));
        System.out.println(map.size());
        System.out.println(map);

        System.out.println("a".hashCode());
        System.out.println("b".hashCode());

    }
}
