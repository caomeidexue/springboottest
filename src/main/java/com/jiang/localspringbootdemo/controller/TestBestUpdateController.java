package com.jiang.localspringbootdemo.controller;

import com.jiang.localspringbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jqb
 * @Description
 * @Date 2020-03-21 16:41
 */
@Controller
public class TestBestUpdateController {

    @Autowired
    private TestService testService;

    @RequestMapping("/updateBatch")
    @ResponseBody
    public Object testBatUpdat(){
        testService.batchUpdate();
        Map<String,String> map = new HashMap<>();
        map.put("result","成功");
        return map;
    }
    @ResponseBody
    @RequestMapping("/updateOne")
    public Object updateOne(){
        testService.updateOne();
        Map<String,String> map = new HashMap<>();
        map.put("result","成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("/insertBatchAndReturnKey")
    public Object insertBatchAndReturnKey(){
        testService.insertBatchAndReturnKey();
        Map<String,String> map = new HashMap<>();
        map.put("result","成功");
        return map;
    }
}
