package com.sf.cap1.config;

import com.sf.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MainConfig {

	@Bean("XXX")
	public Person person01(){
		return new Person("lh",20);
	}
}
