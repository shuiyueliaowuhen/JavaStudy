package com.uni.demo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToMapTest {


    public static void main(String[] args) {
        List<Persion> persionList = new ArrayList<>();

        Persion persion = new Persion("1");
        persionList.add(persion);
        Persion persion1 = new Persion("1");
        persionList.add(persion1);
        Persion persion2 = new Persion("2");
        persionList.add(persion2);

        Map<String, String> collect = persionList.stream().collect(Collectors.toMap(Persion::getId,Persion::getId, (u1, u2) -> {
            return u1+u2;
        }));

        System.out.println(collect);

    }

}
