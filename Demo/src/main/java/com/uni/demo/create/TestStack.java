package com.uni.demo.create;

import java.util.ArrayList;
import java.util.List;

public class TestStack {


    public static void main(String[] args) {


       List<Model> list = new ArrayList<>();
       list.add(new Model());

        Model model ;
        for (int i = 0; i < list.size(); i++) {

            model = list.get(i);
            System.out.println(model);



        }



    }



}
