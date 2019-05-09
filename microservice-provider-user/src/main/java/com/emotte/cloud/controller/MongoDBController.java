package com.emotte.cloud.controller;

import com.emotte.cloud.app.mongodb.MongoPojo;
import com.emotte.cloud.service.MongoDBService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/mongodb")
public class MongoDBController {

    @Resource
    private MongoDBService mongoDBService;

    @RequestMapping("/find")
    public String find(MongoPojo pojo) {
        return mongoDBService.find(pojo);
    }

    @RequestMapping("/save")
    public String save(MongoPojo pojo) {
        return mongoDBService.save(pojo);
    }
}
