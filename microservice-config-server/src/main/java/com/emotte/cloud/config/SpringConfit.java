package com.emotte.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.application")
public class SpringConfit {

    private String name;

    @Bean
    public String getSpringConfit(){
        System.out.println("weiyuchen_application_name= "+name);
        return name;

    }

}
