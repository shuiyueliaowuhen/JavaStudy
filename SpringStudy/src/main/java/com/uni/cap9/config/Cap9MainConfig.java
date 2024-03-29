package com.uni.cap9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.uni.cap9.dao.TestDao;

@Configuration
@ComponentScan({"com.uni.cap9.controller", "com.uni.cap9.service", "com.uni.cap9.dao", "com.uni.cap9.bean"})
public class Cap9MainConfig {
	//spring进行自装配的时候默认首选的bean
	@Primary //只要在这里申请Primary, 代表所有要注入TestDao的bean,
	@Bean("testDao2")
	public TestDao testDao(){
		TestDao testDao = new TestDao();
		testDao.setFlag("2");
		return testDao;
	}
}
