package com.uni.cap1;

import com.uni.cap1.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainTest2 { 
	public static void main(String args[]){

		//配置类加载到容器
		ApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
		//容器中获取类
		Person person = (Person) app.getBean("XXX");
		
		System.out.println(person);
		
		String[] namesForBean = app.getBeanNamesForType(Person.class);
		for(String name:namesForBean){
			System.out.println(name);
		}
		
		
	}
}
