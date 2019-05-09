package com.emotte.cloud.user;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    //https://www.jianshu.com/p/c79b65b253fa
    @Resource(name = "defaultRedisTemplate")
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void stringRedisTest(){
        redisTemplate.opsForValue().set("aaa","111");
    }


}
