package com.emotte.cloud.common.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedisConfig {
    private String password;
    private String clusterNodes;
    private String port;
    private int timeout;
    private String masterName;
}
