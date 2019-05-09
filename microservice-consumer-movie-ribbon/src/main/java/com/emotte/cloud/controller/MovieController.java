package com.emotte.cloud.controller;


import com.emotte.cloud.entity.User;
import com.emotte.ribbonconfiguration.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("movie/{id}")
    public User findById(@PathVariable Long id) {
        //http://localhost:7900/simple/ 改成了用户微服务的serviceid(SpringApplication.name)
        // 这个是VIP virtual IP 虚拟ip
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

}
