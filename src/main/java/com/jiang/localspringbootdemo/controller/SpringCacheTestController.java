package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import com.jiang.localspringbootdemo.service.SrpingCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class SpringCacheTestController {


    @Autowired
    private SrpingCacheService srpingCacheService;


    @RequestMapping("/testcache")
    @ResponseBody
    public Object getPoolData(){

        OtimisticLockAccount otimisticLockAccount = srpingCacheService.getById(1);
        return otimisticLockAccount;
    }


    @RequestMapping("/delCache")
    @ResponseBody
    public Object delCache(){

        srpingCacheService.delCache(1);
        return "success";
    }

}
