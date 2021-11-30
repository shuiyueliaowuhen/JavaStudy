package com.uni.demo.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        String prefixCounter1 = computeIfAbsent(map, "prefix", key -> new Persion("1"))
                .getId();
        System.out.println(prefixCounter1);
        String prefixCounter2 = computeIfAbsent(map, "prefix", key -> new Persion("324"))
                .getId();
        System.out.println(prefixCounter2);
    }
    public static <K, V> V computeIfAbsent(Map<K, V> map, K key, Function<? super K, ? extends V> mappingFunction) {
        V value = map.get(key);
        if (value != null) {
            return value;
        }
        return map.computeIfAbsent(key, mappingFunction);
    }




}
