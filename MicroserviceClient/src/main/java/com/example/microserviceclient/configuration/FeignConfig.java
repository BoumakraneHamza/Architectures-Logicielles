package com.example.microserviceclient.configuration;

import com.example.microserviceclient.exception.CustomErrorDecoder;
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public CustomErrorDecoder customErrorDecoder(){
        return new CustomErrorDecoder();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

}
