package com.uni.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1,2,3,4);
//        list.stream().map(e -> {
//            System.out.println(1);
//            return e;
//        }).map(e -> {
//            System.out.println(2);
//            return e;
//        }).collect(Collectors.toList());

//        String s ="1234";
//        Integer i = null;
//
//        System.out.println(1 == i);

//        BigDecimal bigDecimal = new BigDecimal(0.5);
//        System.out.println(bigDecimal.intValue());



//        String bakCode = "4.3/2020070S";
//        if(bakCode.contains("/")){
//        String REGEX = "[^(0-9)]";
//        String ticket = Pattern.compile(REGEX).matcher(string).replaceAll("").trim();//            bakCode = bakCode.split("/")[1];
//        }
//
//        System.out.println(bakCode);


//        String string = "123S;";
//
//        System.out.println(ticket);

//        System.out.println("1/".split("/").length);

//        String s = "1.0";
//        System.out.println(s.replace(".0",""));


//        String[] s = new String[2];
//        s[0] ="1";
//        s[1] ="2";
//        System.out.println(String.join(",",s));



//        System.out.println(s.substring(2));

//        System.out.println(getCodeNum("4.2/2018224Y-1"));


//        String s1 = "4.2/2018224Y";
//        String s2 = "4.2/2018224Y-1";
//        String s3 = "4.2/2018224Y-1-2";
//        System.out.println(s1.split("-").length < 2);
//        System.out.println(s2.split("-").length < 2);
//        System.out.println(s3.split("-").length < 2);
//        if(project.getDesignCode().split("-").length < 2){
//            throw new ServiceException("项目设计编码错误");
//        }

//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        System.out.println(list.stream().noneMatch(e -> e.equals("A")));


//        for (int i = 0; i < 12; i++) {
//            System.out.println(i % 2);
//        }


        for (int i = 0; i < 101; i++) {
            System.out.println(i%100 == 0);
        }






    }

    private static String getCodeNum(String designCode){

        if(designCode.contains("/")){
            String[] split = designCode.split("/");
            designCode = "";
            for (String s : split) {
                if(s.length() > designCode.length()){
                    designCode = s;
                }
            }
        }

        if (designCode.contains("-")) {
            String[] split = designCode.split("-");
            designCode = "";
            for (String s : split) {
                if (s.length() > designCode.length()) {
                    designCode = s;
                }
            }
        }
        return getNum( designCode );


    }

    private static String getNum(String str){

        String REGEX = "[^(0-9)]";
        return Pattern.compile(REGEX).matcher(str).replaceAll("").trim();

    }

}
