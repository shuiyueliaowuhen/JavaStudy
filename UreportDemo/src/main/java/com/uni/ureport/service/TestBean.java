package com.uni.ureport.service;

import com.uni.ureport.model.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 声明一个类，相当于一个配置文件 bean → 注解@Component
 * 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 */
@Component
public class TestBean {

    /**
     * 方法必须包含三个参数：String，String，Map
     * @return 集合类型 ，包含字段：id,name,salary
     */
    public List<User> loadReportData(String dsName, String datasetName, Map<String, Object> parameters) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            // 模拟数据
            User user = new User();
            user.setId(Long.valueOf( i +""));
            user.setName( RandomStringUtils.random(10, true, false));
            list.add(user);
        }
        return list;
    }

}
