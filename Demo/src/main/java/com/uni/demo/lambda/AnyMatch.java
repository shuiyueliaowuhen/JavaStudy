package com.uni.demo.lambda;

import java.util.ArrayList;
import java.util.List;

public class AnyMatch {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.stream().anyMatch(e -> e.equals("d") ||e.equals("e") ));



    }

}
