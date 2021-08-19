package com.uni.service.impl;


import com.uni.annotation.SfService;
import com.uni.service.HelloService;

@SfService("HelloServiceImpl")
public class HelloServiceImpl implements HelloService {

    public String query(String name, String age) {
        
        return "{name="+name+",age="+age+"}";
    }
    
    public String insert(String param) {
        return  "insert successful.....";
    }
    
    public String update(String param) {
        return "update successful.....";
    }
    
}
