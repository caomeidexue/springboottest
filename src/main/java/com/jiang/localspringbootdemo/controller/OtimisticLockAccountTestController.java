package com.jiang.localspringbootdemo.controller;


import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import com.jiang.localspringbootdemo.mapper.OtimisticLockAccountMapper;
import com.jiang.localspringbootdemo.service.OtimisticLockAccountService;
import com.jiang.localspringbootdemo.util.RedisDistrubuitedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Controller
public class OtimisticLockAccountTestController {


    @Autowired
    private OtimisticLockAccountMapper otimisticLockAccountMapper;


    @Autowired
    private OtimisticLockAccountService otimisticLockAccountService;


    @Autowired
    private RedisDistrubuitedLock lock;

   // @Autowired
    private Jedis jedis;




    @RequestMapping("/insert")
    @ResponseBody
    public String insertObject(){

        OtimisticLockAccount otimisticLockAccount = new OtimisticLockAccount();
        otimisticLockAccount.setUniqueid(UUID.randomUUID().toString());
        otimisticLockAccount.setAmount(100);
        otimisticLockAccount.setVersionAmount(100);
        otimisticLockAccount.setLastModifyTime(new Date());
        otimisticLockAccount.setRemark("测试乐观锁并发控制");
        otimisticLockAccountMapper.insertSelective(otimisticLockAccount);


        return "success";
    }

    /**
     * 乐观锁实现并发提现,提现金额amount,版本提现金额versionamount,每次提现判断本次提现versionamount 是否和amount 相等 相等的话修改不想等返回失败,不加锁
     * @return
     */
    @RequestMapping("/testOptimistickLock")
    @ResponseBody
    public int OtimisticLockAccountTest(){

        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        int a = otimisticLockAccountService.updateDataWitDistructLock(100,100,1);
        if(a == 1){
            System.err.println(a);
        }



        return a;

    }


    private OtimisticLockAccount encapEntity(int amount,int versionamount){
        OtimisticLockAccount account = new OtimisticLockAccount();
        account.setUniqueid("ce2edb76-dfe7-4641-8443-7d1b624df402");
        account.setId(1);
        account.setAmount(0);
        account.setVersionAmount(0);
        account.setCucurrentVersionAmount(100);
        account.setLastModifyTime(new Date());
        return account;
    }


    @ResponseBody
    @RequestMapping("/testOptimistickLockaaaa")
    public int testAAAA(){

       int a = otimisticLockAccountService.updateData(100,100,1);
       if(a == 1){
           System.err.println(a);
       }



        return a;
    }


    @ResponseBody
    @RequestMapping("/testRateLimitera")
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
        jedis.zadd(key,nowTs,UUID.randomUUID().toString());
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
