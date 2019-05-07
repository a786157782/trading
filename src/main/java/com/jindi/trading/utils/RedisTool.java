package com.jindi.trading.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class RedisTool {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String LOCKVALUE = "lockvalue";

    public synchronized boolean getRedisLock(String lockKey){
       boolean b =  redisTemplate.opsForValue().setIfAbsent(lockKey,LOCKVALUE);

       if (b){
           System.out.println("you get lock,start do something");
           redisTemplate.expire(lockKey,1, TimeUnit.MINUTES);
       }else {
           System.out.println("no ");
       }

       return b;

    }
}
