package com.jiang.localspringbootdemo.factory;

import java.util.Objects;

/**
 * @Author jqb
 * @Description
 * @Date 2020-06-05 17:36
 */
public interface IHandler<Dto> {

    Integer getOrderType();

    void execute(Dto dto);
}
