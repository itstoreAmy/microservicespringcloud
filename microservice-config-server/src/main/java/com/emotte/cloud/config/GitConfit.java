package com.emotte.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.cloud.config.server.git")
public class GitConfit {
    private String uri;
    private String username;

    @Bean
    public String getGitConfit(){
        System.out.println("weiyuchenuri= "+uri);
        System.out.println("weiyuchen_name= "+username);
        return uri;

    }

}
