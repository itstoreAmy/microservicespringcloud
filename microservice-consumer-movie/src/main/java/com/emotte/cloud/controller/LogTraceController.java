package com.emotte.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LogTraceController {

    private final Logger logger = LoggerFactory.getLogger(LogTraceController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/movietrace" ,method = RequestMethod.GET)
    public String trace(){
        logger.info("==movie trace==");
        return restTemplate.getForEntity("http://microservice-provider-user/usertrace",String.class).getBody();
    }



}
