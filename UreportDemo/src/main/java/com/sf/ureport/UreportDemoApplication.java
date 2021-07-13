package com.smartarch.user;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.smartarch.platform.EnableCommon;
import com.spring4all.swagger.EnableSwagger2Doc;

@EnableSwagger2Doc
@MapperScan({"com.smartarch.user.mapper"})
@EnableCommon
@EnableTransactionManagement
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		try{
			SpringApplication.run(UserServiceApplication.class, args);

		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
