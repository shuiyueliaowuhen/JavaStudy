package com.sf.demo.create;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ControllerTemplate {

    public static void main(String[] args) {
        String s = readTXT();
        System.out.println(s);

    }

    public static String readTXT() {
        String path =  "../ControllerTemplate.txt";
        path = path.replace("file:/", "");
        path = path.replace("/", "//");
        File file = new File(path);
        StringBuilder sb = new StringBuilder("");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String l = null;
            while ((l = br.readLine()) != null) {
                sb = sb.append(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  sb.toString();
    }

}
