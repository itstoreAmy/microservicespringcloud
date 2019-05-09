package com.emotte.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer     // config注解
//@EnableDiscoveryClient
@EnableEurekaClient // eureka注解
public class MicroserviceConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConfigServerApplication.class,args);

    }
}
