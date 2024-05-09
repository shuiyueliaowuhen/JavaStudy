package com.uni.demo.lambda;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PeekTest {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("哈哈"));
        list.add(new User("嘻嘻"));

        List<User> collect = list.stream().peek(e -> e.setName(e.getName()+"1")).collect(Collectors.toList());
        List<User> collect2 = list.stream().peek(e -> e.setName(e.getName()+"1")).collect(Collectors.toList());

        System.out.println(JSON.toJSONString(collect));


    }


    @Data
    static
    class User {

        private String name;

        public User(String name) {
            this.name = name;
        }
    }

}
