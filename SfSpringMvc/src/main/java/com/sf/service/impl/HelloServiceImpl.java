package com.sf.service.impl;


import com.sf.annotation.SfService;
import com.sf.service.HelloService;

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
