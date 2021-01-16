package com.jiang.localspringbootdemo.model;

import com.jiang.localspringbootdemo.entity.DeliveryBox;
import com.jiang.localspringbootdemo.entity.DeliveryBoxDetail;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DeliveryBoxAndDetailDto extends DeliveryBox implements Serializable {


    /**
     * 箱子明细数据
     */
    private List<DeliveryBoxDetail> itemList;



}