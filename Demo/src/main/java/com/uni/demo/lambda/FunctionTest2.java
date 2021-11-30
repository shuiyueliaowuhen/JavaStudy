package com.uni.demo.lambda;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 functionTest2 = new FunctionTest2();

        Map<String,String> map = new HashMap<>();

        map.computeIfAbsent("1",functionTest2::getValue1);
        map.computeIfAbsent("1",functionTest2::getValue2);
        System.out.println(JSON.toJSONString(map));

    }

    private String getValue1(String key) {
        System.out.println(key);
        return "2";
    }
    private String getValue2(String key) {
        System.out.println(key);
        return "3";
    }





}
