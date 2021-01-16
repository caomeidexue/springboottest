package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.DeliveryBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jqb
 * @Description
 * @Date 2020-03-25 10:54
 */
@Controller
public class DeliveryBoxController {

    @Autowired
    private DeliveryBoxService deliveryBoxService;


    @ResponseBody
    @RequestMapping("batchInsertOnUpdateTest")
    public Object batchInsertOnUpdateTest(){

        deliveryBoxService.batchSaveDeliverBoxDetail();

        return "aaa";
    }

}
