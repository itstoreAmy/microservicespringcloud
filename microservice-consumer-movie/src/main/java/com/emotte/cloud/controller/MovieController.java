package com.emotte.cloud.controller;


import com.emotte.cloud.feign.UserFeignClient;
import com.emotte.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("movie/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("feign/movie/{id}")
    public User findByIdUseFeign(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

    /**
     *


    @GetMapping("/test")
    public User testPost(User user){
        return this.userFeignClient.postUser(user);
    }

    // 该请求不会成功
    @GetMapping("/test-get")
    public User testget(User user){
        return this.userFeignClient.getUser(user);
    }
     */




}
