package com.emotte.cloud.controller;

import com.emotte.cloud.app.kafka.model.KafkaUser;
import com.emotte.cloud.app.user.emerp.model.User;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaController {

    /**
     * 构造器方式注入
     */
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping(value = "/message/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("dddd", 1, message);
        return message;
    }

    @RequestMapping(value = "/user/save")
    public KafkaUser saveUser( KafkaUser user) {
        kafkaTemplate.send("aaaa-user", 0, user);
        return user;
    }
}
