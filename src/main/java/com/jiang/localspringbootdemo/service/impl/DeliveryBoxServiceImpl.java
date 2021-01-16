package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.DeliveryBox;
import com.jiang.localspringbootdemo.entity.DeliveryBoxDetail;
import com.jiang.localspringbootdemo.mapper.DeliveryBoxMapper;
import com.jiang.localspringbootdemo.service.DeliveryBoxService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author jqb
 * @Description
 * @Date 2020-03-25 10:55
 */

@Service
public class DeliveryBoxServiceImpl implements DeliveryBoxService {


    @Autowired
    private DeliveryBoxMapper deliveryBoxMapper;

    /**
     * 批量插入更新返回主键
     */
    @Override
    public void batchSaveDeliverBoxDetail() {

        List<DeliveryBoxDetail> list = new ArrayList<>();

        deliveryBoxMapper.batchSaveDeliverBoxEncap(list);
    }
}
