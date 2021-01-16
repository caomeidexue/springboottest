package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import com.jiang.localspringbootdemo.entity.DeliveryBox;
import com.jiang.localspringbootdemo.entity.DeliveryBoxDetail;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DeliveryBoxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryBox record);

    int insertSelective(DeliveryBox record);

    @PhysicalTableAnnotation(tableName = "order_table",type = DeliveryBoxMapper.class)
    DeliveryBox selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DeliveryBox record);

    int updateByPrimaryKey(DeliveryBox record);

    void batchSaveDeliverBoxEncap(List<DeliveryBoxDetail> list);
}