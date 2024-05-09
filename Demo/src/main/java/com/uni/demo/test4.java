package com.uni.demo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class test4 {

    public static void main(String[] args) {
        //String s = "厉建军\t唐玉宏\t王建发\t殷立娟\t蒋靓\t梁红\t经营管理部\t高质量发展研究院\t技术产品研究院\t专家工作室\t";
        //s += "区域本部\t区域一部\t区域二部\t区域三部\t区域四部\t王峰\t管凛\t凌俊\t任云\t董梁涛\t张红明\t杨超\t";
        //s += "袁忠伟\t孔宇\t古杏红\t黄晓东\t孙鹏\t燕强\t杨小平\t沈巍\t殷波\t郝显荣\t戴德胜\t王威\t王阿华\t王心联";
        //
        //String[] split = s.split("\\t");
        //
        //for (int i = 0; i < split.length; i++) {
        //
        //    System.out.println(String.format("insert into ofc_remarks_personal(id,user_name,type,remarks_id) values(%d,'%s','%s','%s');",i,split[i],"performance_appraisal_2022","5"));
        //}



        //bead dto = new bead();
        //Field i = dto.getClass().getField("id");
        //Class<?> type = i.getType();
        //Object o = BeanUtils.copyBean("123", type);
        //System.out.println(o);


        List<Object> list = new ArrayList<>();
        list.add("123");
        list.add(124L);
        list.add(125L);
        Object l = "123";
        System.out.println(list.contains(l));






    }




}
