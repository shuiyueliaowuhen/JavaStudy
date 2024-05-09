package com.uni.demo;

import java.util.ArrayList;
import java.util.List;

public class hhh {



    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");

        String s = list.stream().filter("1"::equals).findFirst().orElse("3");
        System.out.println(s);


    }


}
