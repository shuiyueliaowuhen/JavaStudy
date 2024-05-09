package com.uni.demo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TTT {

    public static void main(String[] args) {
        //List<ttt> list = new ArrayList<>();
        //list.add(new ttt("1","2"));
        //list.add(new ttt("2","3"));
        //list.add(new ttt("2","4"));
        //
        //List<ttt> ttts = get("4", new ttt("1", "2"), list);
        //
        //System.out.println(JSON.toJSONString(ttts));

        //System.out.println(new Timestamp(System.currentTimeMillis()).getYear());


        //List<String> l = new ArrayList<>();
        //l.add("1");
        //l.add("3");
        //l.add("2");
        //l.sort(Comparator.comparing(e -> e));
        //System.out.println(JSON.toJSONString(l));


        LocalDate nowDay = LocalDate.now().minusDays(1);//昨天
        LocalDate preDate = nowDay.minusMonths(1);
        String preMonth = preDate.getYear() +"-"+ String.format("%02d",preDate.getMonth().getValue());
        System.out.println(preMonth);



    }

    public static List<ttt> get(String end,ttt t,List<ttt> list){

        List<ttt> result = new ArrayList<>();

        List<ttt> collect = list.stream().filter(e -> e.getS().equals(t.getE())).collect(Collectors.toList());

        if(collect.size() == 0)
            return null;

        Optional<ttt> first = collect.stream().filter(e -> e.getS().equals(end)).findFirst();
        if(first.isPresent()){
            result.add(first.get());
            return result;
        }

        for (ttt e : collect) {
            result.add(e);
            return get(end,e,list);

        }

        return result;


    }


    @Data
    static class ttt{
        String s ;
        String e;

        public ttt(String s, String e) {
            this.s = s;
            this.e = e;
        }
    }

}
