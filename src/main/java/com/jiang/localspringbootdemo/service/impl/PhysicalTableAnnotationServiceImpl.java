package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import com.jiang.localspringbootdemo.entity.DeliveryBox;
import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import com.jiang.localspringbootdemo.mapper.DeliveryBoxMapper;
import com.jiang.localspringbootdemo.mapper.ZrSyncafaResultMapper;
import com.jiang.localspringbootdemo.service.PhysicalTableAnnotationService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-22 17:30
 */
@Service
public class PhysicalTableAnnotationServiceImpl implements PhysicalTableAnnotationService {


    /**
     * 这个mapper 的接口有切面注解
     */
    @Autowired
    private ZrSyncafaResultMapper zrSyncafaResultMapper;

    @Override
    public int testAnnotation() {
        zrSyncafaResultMapper.selectAll();
        ZrSyncafaResult result1 = new ZrSyncafaResult();
        result1.setCreateTime(new Date());
        result1.setCustomerTrxId("123456");
        result1.setErrMsg("aaa1");
        result1.setIsClose(0);
        result1.setIsDel(0);
        result1.setStatus("22");
        result1.setUniqueBusinessId("1111");
        result1.setTrxNumber("bbb1");
        result1.setId(1);
        zrSyncafaResultMapper.updateByPrimaryKey(result1);

        List<ZrSyncafaResult> list = new ArrayList<>();
        ZrSyncafaResult zrSyncafaResult = new ZrSyncafaResult();
        zrSyncafaResult.setCreateTime(new Date());
        zrSyncafaResult.setCustomerTrxId("123456");
        zrSyncafaResult.setErrMsg("aaa1");
        zrSyncafaResult.setIsClose(0);
        zrSyncafaResult.setIsDel(0);
        zrSyncafaResult.setStatus("22");
        zrSyncafaResult.setUniqueBusinessId("1111");
        zrSyncafaResult.setTrxNumber("bbb1");



        ZrSyncafaResult result = new ZrSyncafaResult();
        result.setCreateTime(new Date());
        result.setCustomerTrxId("123456");
        result.setErrMsg("aaa2");
        result.setIsClose(0);
        result.setIsDel(0);
        result.setStatus("22");
        result.setUniqueBusinessId("1111");
        result.setTrxNumber("bbb2");


        list.add(zrSyncafaResult);
        list.add(zrSyncafaResult);
        // list.add(result);
        zrSyncafaResultMapper.batchInsertOnUpdate(list);

        System.out.println(1111);

        return 1;

    }
}
