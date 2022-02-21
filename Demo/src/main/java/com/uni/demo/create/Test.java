package com.uni.demo.create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args)throws Exception {
//        List<String> list = readFile0( "/Users/songfei/code/JavaStudy/Demo/src/main/java/com/uni/demo/create/ControllerTemplate.txt");
        List<String> list = readFile0( "/Users/songfei/code/JavaStudy/Demo/src/main/java/com/uni/demo/create/ServiceTemplate.txt");



        list.forEach(str -> {
            str = str.replaceAll("@value1@","arcBorrowArchive");
            str = str.replaceAll("@value2@","ArcBorrowArchive");
            str = str.replaceAll("@value3@","档案");
            System.out.println(str);
        });
    }

    public static List<String> readFile0(String path) throws IOException {
        List<String> result = new ArrayList<>();
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        String line="";
        while ((line=br.readLine())!=null) {
            result.add(line);
        }
        br.close();
        fr.close();
        return result;
    }


}
