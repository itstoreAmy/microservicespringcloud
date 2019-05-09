package com.emotte.cloud.controller;

import com.emotte.cloud.entity.User;
import com.emotte.cloud.feign.UserFeignClient;
import com.emotte.cloud.feign.UserFeignHyClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserFeignHyClient userFeignHyClient;


    /**
     * restTemplate+hystrix
     * @param id
     * @return
     */
    @GetMapping("/hystrix/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallBack")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }
    public User findByIdFallBack(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
    }

    /**
     * fegin+hystrix
     * @param id
     * @return
     */
    @GetMapping("/hystrixFe/movie/{id}")
    public User findByIdHyFe(@PathVariable Long id) {
        User user = null;
        user = this.userFeignHyClient.findByIdHy(id);
        return user;
    }


    /**
     * 设置访问线程与hystrix线程为同一个线程
     * 官方不建议这么做
     * @param id
     * @return
     */
//    @GetMapping("/hystrix2/movie/{id}")
//    @HystrixCommand(fallbackMethod = "findByIdFallBack", commandProperties = {
//            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
//    })
//    public User findById2(@PathVariable Long id) {
//        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
//    }


}
