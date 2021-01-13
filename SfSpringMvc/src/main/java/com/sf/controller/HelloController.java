package com.sf.controller;


import com.sf.annotation.SfController;
import com.sf.annotation.SfQualifier;
import com.sf.annotation.SfRequestMapping;
import com.sf.annotation.SfRequestParam;
import com.sf.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SfController
@SfRequestMapping("/james")
public class HelloController {


    @SfQualifier("HelloServiceImpl")
    private HelloService helloService;

    @SfRequestMapping("/query")
    public void query(HttpServletRequest request, HttpServletResponse response,
                      @SfRequestParam("name") String name,
                      @SfRequestParam("age") String age) {

        try {
            PrintWriter pw = response.getWriter();
            String result = helloService.query(name,age);
            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SfRequestMapping("/insert")
    public void insert(HttpServletRequest request,
                       HttpServletResponse response) {
        try {
            PrintWriter pw = response.getWriter();
            String result = helloService.insert("0000");

            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SfRequestMapping("/update")
    public void update(HttpServletRequest request,
                       HttpServletResponse response, String param) {
        try {
            PrintWriter pw = response.getWriter();
            String result = helloService.update(param);

            pw.write(result);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}

