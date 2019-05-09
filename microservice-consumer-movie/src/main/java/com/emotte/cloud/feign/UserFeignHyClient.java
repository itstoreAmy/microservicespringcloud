package com.emotte.cloud.feign;

import com.emotte.cloud.entity.User;
import com.emotte.config.FeignConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * configuration 修改feign的默认配置
 * configuration = FeignConfiguration.class
 * 一般不用
 */
@FeignClient(value = "microservice-provider-user", fallback = UserFeignHyClient.HystrixClientFallback.class)
@Component
public interface UserFeignHyClient {


    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findByIdHy(@PathVariable("id") Long id);


    @Component
    static class HystrixClientFallback implements UserFeignHyClient {
        @Override
        public User findByIdHy(Long id) {
            User user = new User();
            user.setId(-1L);
            return user;
        }
    }


}

