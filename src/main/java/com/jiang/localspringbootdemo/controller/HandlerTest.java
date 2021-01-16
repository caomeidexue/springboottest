package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.factory.AutoWiredFactory;
import com.jiang.localspringbootdemo.factory.XXXFactory;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jqb
 * @Description
 * @Date 2020-06-05 17:45
 */
@RestController
public class HandlerTest {


    @Autowired
    private XXXFactory xxxFactory;

    @Autowired
    private AutoWiredFactory autoWiredFactory;

    @RequestMapping("/test1")
    public Object testFactory(Integer orderType){
        //调用
        xxxFactory.getHandler(orderType).execute(null);
        return "success";
    }@RequestMapping("/test2")
    public Object testFactory2(Integer orderType){
        //调用
        autoWiredFactory.execute(orderType,null);
        return "success";
    }
}
