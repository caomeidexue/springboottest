package com.jiang.localspringbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import com.jiang.localspringbootdemo.service.PhysicalTableAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-22 17:21
 */
@Controller
public class PhysicalTableAnnotationTestController {


    @Autowired
    private PhysicalTableAnnotationService physicalTableAnnotationService;


    @ResponseBody
    @RequestMapping("testannotation")
    public Object batchInsertOnUpdateTest(){
        physicalTableAnnotationService.testAnnotation();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","成功");
        return jsonObject;
    }
}
