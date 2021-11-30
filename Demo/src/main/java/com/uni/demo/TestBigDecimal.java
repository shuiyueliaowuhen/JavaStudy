package com.uni.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class TestBigDecimal {


    public static void main(String[] args) {
//        BigDecimal bigDecimal = new BigDecimal(10);
//        BigDecimal bigDecimal1 = new BigDecimal(3);
//        BigDecimal divide = bigDecimal.divide(bigDecimal1， );
//        System.out.println(divide.toString());


//        BigDecimal bigDecimal1 = new BigDecimal(10);
//        BigDecimal bigDecimal2 = new BigDecimal(10.00F);
//        System.out.println(bigDecimal2.equals(bigDecimal1));

//        String str = "%";
//
//        System.out.println(str.equals("%"));

            BigDecimal bg1 = new BigDecimal(1);
            BigDecimal bg2 = new BigDecimal(3);
            System.out.println(bg1.divide(bg2,4, RoundingMode.HALF_UP));

//        for(int i = 0; i< 6;i++){
//            System.out.println(i);
//            break;
//        }



//        staffList = new ArrayList<>(staffList.stream().collect(Collectors.toMap(ProjectStaffOutput::getUserId, a -> a, (o1, o2) -> {
//            o1.setAllocateAmount(o1.getAllocateAmount().add(o2.getAllocateAmount()));
//            return o1;
//        })).values());


    }

}
