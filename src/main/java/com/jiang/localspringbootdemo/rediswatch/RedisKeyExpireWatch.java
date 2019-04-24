package com.jiang.localspringbootdemo.rediswatch;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisKeyExpireWatch  {


    //监听redis key实效时间

    public void receiveMessage(String messge) {

        System.out.println("频道topic:"+messge);
        //System.out.println("过期的键值对的K:"+itemValue);

    }
}
