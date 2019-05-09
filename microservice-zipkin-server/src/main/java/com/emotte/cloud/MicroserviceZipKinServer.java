package com.emotte.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

//@EnableZipkinServer
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinStreamServer
public class MicroserviceZipKinServer {

    public static void main(String[] args){
        SpringApplication.run(MicroserviceZipKinServer.class,args);
    }
}
