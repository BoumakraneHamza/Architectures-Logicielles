package com.example.microserviceproduits.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("mes-configs")
public class ApplicationPropertiesConfiguration {
    private int limitDeProduits;
}