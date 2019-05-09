package com.emotte.cloud;

import com.emotte.ribbonconfiguration.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "microservice-provider-user", configuration = UserConfiguration.class)
public class MicroserviceConsumerMovieRibbonApplication {

    /**
     * 添加 @LoadBalanced 让restTemplate 实现负载均衡的能力
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieRibbonApplication.class,args);
    }
}
