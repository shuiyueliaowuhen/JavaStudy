package com.uni.cap2.config;

import com.uni.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(value= "com.uni.cap2", includeFilters={
		@Filter(type=FilterType.CUSTOM, classes={JamesTypeFilter.class})		
}, useDefaultFilters=false)


public class Cap2MainConfig {
	@Bean
	public Person person01(){
		return new Person("sf",20);
	}
}
