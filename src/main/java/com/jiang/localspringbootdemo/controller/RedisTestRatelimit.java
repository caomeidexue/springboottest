package com.jiang.localspringbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.UUID;


@Controller
public class RedisTestRatelimit {

    @Autowired
    private Jedis jedis;


    @ResponseBody
    @RequestMapping("/testRateLimiter")
    public int testRateLimiter(){
        /**
         * jiang1,在60秒内最多操作5次
         */
        boolean actionAllowed = actionAllowed("jiang1", "jiang", 60, 5);
        if (actionAllowed){
            System.out.println("允许操作");
        }else {
            System.out.println("不允许操作");
        }


        return 1;
    }

    /**
     * 时间窗口允许操作的次数,适合数据量不是特别大的场景
     * @param userId
     * @param actionKey
     * @param period 活动窗口期时间,
     * @param maxCount 在限定时间的最大操作次数
     *
     * @return
     */

    public boolean actionAllowed(String userId,String actionKey,int period,int maxCount){
        String key = String.format("hist:%s:%s",userId,actionKey);
        long nowTs = System.currentTimeMillis();
        jedis.zadd(key,nowTs, UUID.randomUUID().toString());
        long end =nowTs - period*1000;
        jedis.zremrangeByScore(key,0,end);
        Long count = jedis.zcard(key);
        jedis.expire(key,period+1);
        if (count.intValue()>maxCount){
            return false;
        }else {
            return true;
        }

    }
}
