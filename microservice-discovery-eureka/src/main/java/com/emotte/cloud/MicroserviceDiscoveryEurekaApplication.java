package com.emotte.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 加入EnableEurekaServer 表明是eureka的服务端
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroserviceDiscoveryEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDiscoveryEurekaApplication.class,args);

    }
}
