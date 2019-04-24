package com.jiang.localspringbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;

@RestController
public class RedisBigMapsController {

   // @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //@Autowired
    private Jedis jedis;




    private static final int BIT_AMOUNT_IN_ONE_BYTE =8;



    public int bitCountByBitIndex(String key, long startBitIndex, long endBitIndex) {
        int startByteIndex = getByteIndexInTheBytes(startBitIndex);
        int endByteIndex = getByteIndexInTheBytes(endBitIndex);
        byte[] bytes = jedis.getrange(key.getBytes(), startByteIndex, endByteIndex);
        int totalBitInBytes = getTotalBitInBytes(bytes);
        int startBitIndexInFirstByte = getBitIndexInTheByte(startBitIndex);
        int endBitIndexInLastByte = getBitIndexInTheByte(endBitIndex);
        byte firstByte = bytes[0];
        byte lastByte = bytes[bytes.length-1];
        for(int i=7;i>(BIT_AMOUNT_IN_ONE_BYTE-1-startBitIndexInFirstByte);i--){
            if(((firstByte>>i)&1)==1){
                totalBitInBytes--;
            }
        }
        for(int i=0;i<(BIT_AMOUNT_IN_ONE_BYTE-1-endBitIndexInLastByte);i++){
            if(((lastByte>>i)&1)==1){
                totalBitInBytes--;
            }
        }

        return totalBitInBytes;
    }

    private int getTotalBitInBytes(byte[] bytes){
        int count=0;
        for(byte b:bytes){
            for(int i = 0; i< BIT_AMOUNT_IN_ONE_BYTE; i++){
                if(((b>>i)&1)==1){
                    count++;
                }
            }
        }
        return count;
    }

    private int getByteIndexInTheBytes(long offset){
        return (int) offset/ BIT_AMOUNT_IN_ONE_BYTE;
    }

    private int getBitIndexInTheByte(long offset){
        return (int)(offset-offset/ BIT_AMOUNT_IN_ONE_BYTE * BIT_AMOUNT_IN_ONE_BYTE);
    }







        //日期的初始值（也可以理解为用户的注册时间），
        //下文需要使用日期的偏移量作为redis位图的offset，
        //因此需要将要保存登录状态的日期减去该初始日期。
        //这里使用了Java 8的新日期API
        private  final LocalDate beginDate=LocalDate.of(2018,1,1);



        public void setLoginStatus(String userId, LocalDate date,boolean isLogin){
            long offset = getDateDuration(beginDate, date);
            jedis.setbit(userId,offset,isLogin);
        }

        public boolean getLoginStatus(String userId,LocalDate date){
            long offset = getDateDuration(beginDate, date);
            return jedis.getbit(userId,offset);
        }

        private long getDateDuration(LocalDate start ,LocalDate end){
            return start.until(end, ChronoUnit.DAYS);
        }

        @RequestMapping("/testA")
        @ResponseBody
        public  void testaaa(String[] args) {

            String userId="user_1";
            LocalDate today = LocalDate.now();
            setLoginStatus(userId,today,true);
            LocalDate yestaday = today.minusDays(1);
            setLoginStatus(userId,yestaday,true);
            LocalDate theDayBefoYestaay = yestaday.minusDays(1);
            setLoginStatus(userId,theDayBefoYestaay,true);

            boolean todayLoginStatus = getLoginStatus(userId, today);

            System.out.println(String.format("The loginStatus of %s in %s is %s",userId,today,todayLoginStatus));
            LocalDate yesterday = LocalDate.now().minusDays(1);
            boolean yesterdayLoginStatus = getLoginStatus(userId, yesterday);
            System.out.println(String.format("The loginStatus of %s in %s is %s",userId,yesterday,yesterdayLoginStatus));

            int i = bitCountByBitIndex(userId, getDateDuration(beginDate, theDayBefoYestaay), getDateDuration(beginDate, today));
            System.out.println(i);
        }







}
