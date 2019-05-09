package com.emotte.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceGatewayZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceGatewayZuulApplication.class, args);
    }


    /**
     * 版本控制
     * user-V1
     * http://localhost:8040/V1/user
     * @return
     */
//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
//    }
}

