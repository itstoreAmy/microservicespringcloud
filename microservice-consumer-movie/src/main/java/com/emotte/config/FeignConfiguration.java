package com.emotte.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfiguration {

    /**
     * 将访问改成feign的访问
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

//    @Bean
//    Logger.Level feignLoggerLevel() {
//        return Logger.Level.FULL;
//    }
}
