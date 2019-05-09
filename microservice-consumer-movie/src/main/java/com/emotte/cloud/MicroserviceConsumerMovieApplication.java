package com.emotte.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker   // hystrix
public class MicroserviceConsumerMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerMovieApplication.class, args);
    }

    /**
     * RestTempate http:
     * 注入RestTemplate
     * 等价于 private RestTemplate restTemplate = new RestTemplate()
     * LoadBalanced 实现负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
