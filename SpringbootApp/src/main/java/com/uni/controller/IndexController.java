package com.uni.controller;

import com.uni.model.Person;
import com.uni.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class IndexController {


    @Autowired
    private IndexService indexService;




    @GetMapping("/test")
    public String test() {

        List<Person> list = new ArrayList<>();
        list.add(new Person("张三",10));
        list.add(new Person("李四",20));

        indexService.test(list);

        return "ok";
    }


}
