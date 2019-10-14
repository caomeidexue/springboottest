package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.AbstractClassValueTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 11:04
 */

@Controller
public class AbstractClassValueTest {

    @Autowired
    private AbstractClassValueTestService abstractClassValueTestService;


    @RequestMapping("testAtValue")
    @ResponseBody
    public Object testAtValue(){
        String aaa = abstractClassValueTestService.getValue();
        return aaa;
    }
}
