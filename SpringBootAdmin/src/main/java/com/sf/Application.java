package com.sf;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
class AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class,args);
    }
}

