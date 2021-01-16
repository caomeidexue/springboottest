package com.jiang.localspringbootdemo.factory;

import org.springframework.stereotype.Service;

/**
 * @Author jqb
 * @Description
 * @Date 2020-06-05 17:44
 */
@Service
public class TwoXxxHandler implements IHandler {

    @Override
    public Integer getOrderType() {
        return 2;
    }

    @Override
    public void execute(Object o) {
        System.out.println(222);
    }
}
