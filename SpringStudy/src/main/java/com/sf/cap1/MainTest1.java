package com.sf.cap1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest1 { 
	public static void main(String args[]){
        //将beans.xml的类加载到容器
		ApplicationContext app = new ClassPathXmlApplicationContext("beans.xml");
		//从容器中获取bean
		Person person = (Person) app.getBean("person");
		
		System.out.println(person);
	}
}
