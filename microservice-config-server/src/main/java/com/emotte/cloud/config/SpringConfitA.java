package com.emotte.cloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "server")
public class SpringConfitA {

    private String port;

    @Bean
    public String getSpringConfitA(){
        File file = new File("/resources/bootstrap.yml");
        System.out.println("好像"+ClassLoader.getSystemResource("bootstrap.yml"));

        if(file.exists()){
            System.out.println("weiyuchen_application_port= 我是文件啊哈哈哈");
        }
        System.out.println("weiyuchen_application_port= "+port);
        return port;

    }

}
