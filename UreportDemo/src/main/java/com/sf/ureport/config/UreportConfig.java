package com.smartarch.user.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import  com.bstek.ureport.console.UReportServlet;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.Servlet;

@ImportResource("classpath:context.xml")
@Configuration
public class UreportConfig {

    @Bean
    public ServletRegistrationBean<Servlet> ureport2Servlet() {
        return new ServletRegistrationBean<>(new UReportServlet(), "/ureport/*");
    }



}
