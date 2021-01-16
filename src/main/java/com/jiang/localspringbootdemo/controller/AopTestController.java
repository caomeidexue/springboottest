package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jqb
 * @Description
 * @Date 2020-05-19 12:52
 */
@RestController
public class AopTestController {


    @Autowired
    private AopService aopService;


    @PostMapping("/testaopservice")
    public Object testAop(){
        for (int j = 0; j < 10; j++) {
            try {
                aopService.caclate(j);
            }catch (Exception e){
                System.out.println("切面入口");
                System.out.println(e);
                continue;
            }
            System.out.println("本次进入:j"+j);

        }

        return "sucess";
    }
}
