package com.uni.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {


        String s = null;
        String ss = Optional.ofNullable(s).map(s1 -> {
            System.out.println(s1);
            System.out.println("执行");
            return s1;
        }).orElseGet(()->"s");
        System.out.println(ss);

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
