package com.emotte.cloud.common.database.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "spring.datasource.emotte")
@Component
public class DataSourceConfigEmotte {

    private String driverClassName;
    private String url;
    private String	username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int borrowConnectionTimeout;
    private String testQuery;
    private int loginTimeout;
    private int maxIdleTime;
}
