package com.uni.service;

import com.uni.annoation.ChangeData;
import com.uni.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Service
@Validated
public class IndexService {


    public void test( @ChangeData List<Person> list){

        list.forEach(System.out::println);

    }








}





