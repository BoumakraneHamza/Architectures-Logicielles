package com.example.microserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableFeignClients("com.example.microserviceclient")
@CrossOrigin("*")
public class MicroserviceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceClientApplication.class, args);
    }
}
