package com.emotte.cloud.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Component
public class ZJedisPool {

    @Resource
    private RedisPoolConfig redisPoolConfig;

    @Resource
    private RedisConfig redisConfig;


    @Bean(value = "jedis")
    public Jedis getJedis(){
        if(redisConfig.getPort() == null){
            return getJedisSentinelPool().getResource();
        }
        return getJedisPool().getResource();
    }

    private JedisPool getJedisPool(){
        return new JedisPool(getJedisPoolConfig(),redisConfig.getClusterNodes(),Integer.parseInt(redisConfig.getPort()),redisConfig.getTimeout(),redisConfig.getPassword());
    }


    private JedisSentinelPool getJedisSentinelPool() {
        Set<String> sentinels = new HashSet<>();
        String[] hostAndPort = redisConfig.getClusterNodes().split(",");
        for (String s : hostAndPort){
            sentinels.add(s);
        }
        return new JedisSentinelPool(redisConfig.getMasterName(),sentinels,getJedisPoolConfig(),redisConfig.getPassword());

    }

    private JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisPoolConfig.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisPoolConfig.getMinIdle());
        jedisPoolConfig.setMaxTotal(redisPoolConfig.getMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(redisPoolConfig.getMaxWait());
        return jedisPoolConfig;

    }
}
