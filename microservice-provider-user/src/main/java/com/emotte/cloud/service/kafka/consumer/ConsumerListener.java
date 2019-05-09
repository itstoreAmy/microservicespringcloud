package com.emotte.cloud.service.kafka.consumer;

import com.emotte.cloud.app.kafka.model.KafkaUser;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消费者监听
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics = "dddd")
    public void consumer(String message) {
        System.out.println("condumerListener: " + message);
    }

    @KafkaListener(topics = "aaaa-user")
    public void consumer(KafkaUser user) {
        System.err.println("condumerListener: " + user);
    }


}
