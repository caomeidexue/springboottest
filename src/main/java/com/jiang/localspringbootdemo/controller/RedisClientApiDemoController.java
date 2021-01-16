package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.DeliveryBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-29 10:51
 */

@RestController
public class RedisClientApiDemoController {


    @Autowired
    private Jedis jedis;

    @RequestMapping("/testredisapi")
    public Object redisApi(){


        return null;
    }
}
