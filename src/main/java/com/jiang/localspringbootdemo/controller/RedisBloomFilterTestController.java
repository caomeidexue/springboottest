package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.config.bloomfilter.BloomFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class RedisBloomFilterTestController {


    @Autowired
    private BloomFilter bloomFilter;




    @RequestMapping("/testRedisBloomFilter")
    @ResponseBody
    public Object testRedisBloomFilter(){
        System.out.println(bloomFilter.isExist("aaa", "aaa"));
        System.out.println(bloomFilter.isExist("aaa", "aaa"));
        System.out.println(bloomFilter.isExist("aaa", "bbb"));
        System.out.println(bloomFilter.isExist("bbb", "aaa"));

        return "success";
    }
}
