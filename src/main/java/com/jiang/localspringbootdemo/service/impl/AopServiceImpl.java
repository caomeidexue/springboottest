package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.service.AopService;
import org.springframework.stereotype.Service;

/**
 * @Author jqb
 * @Description
 * @Date 2020-05-19 12:53
 */
@Service
public class AopServiceImpl implements AopService {


    @Override
    public void caclate(int j) {
        if (j == 5){
            throw new RuntimeException("计算异常j:"+ j);
        }
    }
}
