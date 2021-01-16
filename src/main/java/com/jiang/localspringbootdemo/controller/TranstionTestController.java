package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-11-28 17:33
 */
@Controller
public class TranstionTestController {

    @Autowired
    private TransactionalService transactionalService;


    @RequestMapping("/testServiceTransantion")
    @ResponseBody
    public Object testServiceTransantion(){
        transactionalService.testInsertTransaction();
        return "ok";
    }

}
