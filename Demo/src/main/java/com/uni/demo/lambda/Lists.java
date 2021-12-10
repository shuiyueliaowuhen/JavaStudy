package com.uni.demo.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Lists {


    public static void main(String[] args) {

        List<Persion> list = new ArrayList<>();
        list.add(new Persion(new BigDecimal(1)));
        list.add(new Persion(new BigDecimal(2)));
        list.add(new Persion(new BigDecimal(3)));
        System.out.println( reduce(list,Persion::getAmount) );

    }

    static <T> BigDecimal reduce(List<T> list, Function<? super T,BigDecimal> keyExtractor){
        return list.stream().map(keyExtractor).reduce(new BigDecimal(0),BigDecimal::add);
    }



}
