package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.DeliveryBoxDetail;

public interface DeliveryBoxDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryBoxDetail record);

    int insertSelective(DeliveryBoxDetail record);

    DeliveryBoxDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryBoxDetail record);

    int updateByPrimaryKey(DeliveryBoxDetail record);
}