package com.emotte.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);


    @Resource
    RedisTemplate redisTemplate;

    @RequestMapping("/set")
    public void set(){
        redisTemplate.opsForValue().set("yzyz","2222");
    }

    @RequestMapping("/show")
    public String show(){
        logger.info(redisTemplate.opsForValue().get("yzyz").toString());
        Object yzyz = redisTemplate.opsForValue().get("yzyz");
        return JSONObject.toJSONString(yzyz);
    }



}
