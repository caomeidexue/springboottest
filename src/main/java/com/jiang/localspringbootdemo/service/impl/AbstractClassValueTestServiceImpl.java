package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.config.testautowired.TestAutoWired;
import com.jiang.localspringbootdemo.service.AbstractClassValueTestService;
import com.jiang.localspringbootdemo.template.AtValueTempleateService;
import com.jiang.localspringbootdemo.template.impl.AtValueTempleateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 11:06
 */

@Service
public class AbstractClassValueTestServiceImpl implements AbstractClassValueTestService {


    @Autowired
    private TestAutoWired testAutoWired;




    private   AtValueTempleateService atValueTempleateService;

    @Value("abstract.valuetest")
    private String aaa;


    @Override
    public String getValue() {
        System.out.println(aaa);
        testAutoWired.getTestAutoWiredString();
        atValueTempleateService = new AtValueTempleateServiceImpl();
        return atValueTempleateService.getTestValue();
    }
}
