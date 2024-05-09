package com.uni.demo.pands;

import java.util.ArrayList;
import java.util.List;

public class Son extends Parent{


    //@Override
    //public void ttt() {
    //    ttt1();
    //    System.out.println("son");
    //
    //}

    protected void ttt1(){
        System.out.println("son111");
    }


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("开始"+System.currentTimeMillis());
        list.parallelStream().forEach(e->{

            try {
                Thread.sleep(5000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }

            System.out.println(System.currentTimeMillis()+"--"+e);


        });


        System.out.println("结束"+System.currentTimeMillis());




        //Son son = new Son();
        //son.ttt();
        //son.ttt1();
    }
}
