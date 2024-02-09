package com.example.microserviceproduits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.example.microserviceproduits.web.controller"),
        @ComponentScan("com.example.microserviceproduits.web.exception"),
        @ComponentScan("com.example.microserviceproduits.dao"),
        @ComponentScan("com.example.microserviceproduits.model"),
})
public class MicroserviceProduitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProduitsApplication.class, args);
    }
}
