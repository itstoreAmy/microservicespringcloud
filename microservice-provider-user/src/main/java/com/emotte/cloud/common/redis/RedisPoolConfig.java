package com.emotte.cloud.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis.pool")
@Data
public class RedisPoolConfig {
    private int maxWait;
    private int maxIdle;
    private int minIdle;
    private int maxTotal;


}
