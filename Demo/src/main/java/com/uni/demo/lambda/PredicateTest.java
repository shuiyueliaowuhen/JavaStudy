package com.uni.demo.lambda;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class PredicateTest {


    public static void main(String[] args) {
        List<BigDecimal> l = new ArrayList<>();
        l.add(new BigDecimal(1));
        l.add(new BigDecimal(3));
        l.add(new BigDecimal(1));
//        System.out.println( add(l,Test::t) );
        System.out.println( add(l,(i) -> new BigDecimal(1).compareTo(i) == 0 ) );

        Predicate<BigDecimal> p= (i) -> new BigDecimal(1).compareTo(i) == 0;
//        p = p.and( (i) -> new BigDecimal(0).compareTo(i) == 0 );
        System.out.println( add(l,p.negate()));


    }

    public static BigDecimal add(List<BigDecimal> l, Predicate<BigDecimal> predicate){
        return l.stream().filter(predicate).reduce(new BigDecimal(0),BigDecimal::add);

    }

    public static boolean t(BigDecimal i){
        return new BigDecimal(1).compareTo(i) == 0;
    }

}
