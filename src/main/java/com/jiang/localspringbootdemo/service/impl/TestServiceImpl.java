package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import com.jiang.localspringbootdemo.mapper.ZrSyncafaResultMapper;
import com.jiang.localspringbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    private ZrSyncafaResultMapper zrSyncafaResultMapper;

    @Override
    public void insert() {

        ZrSyncafaResult zrSyncafaResult = new ZrSyncafaResult();
        zrSyncafaResult.setCreateTime(new Date());
        zrSyncafaResult.setCustomerTrxId("123456");
        zrSyncafaResult.setErrMsg("aaa");
        zrSyncafaResult.setIsClose(0);
        zrSyncafaResult.setIsDel(0);
        zrSyncafaResult.setStatus("22");
        zrSyncafaResult.setUniqueBusinessId("1");
        zrSyncafaResult.setTrxNumber("bbb");
        zrSyncafaResultMapper.insertSelective(zrSyncafaResult);
    }


    @Override
    @Transactional(timeout = 30)
    public void batchInsert() {
        List<ZrSyncafaResult> list =  getInsertlist();
        for (int i = 0; i < list.size(); i++) {
            zrSyncafaResultMapper.insertSelective(list.get(i));
        }
    }

    /**
     * 封装list
     * @return
     */
    private List<ZrSyncafaResult> getInsertlist() {

        List<ZrSyncafaResult> list = new ArrayList<>();
        ZrSyncafaResult zrSyncafaResult = new ZrSyncafaResult();
        zrSyncafaResult.setCreateTime(new Date());
        zrSyncafaResult.setCustomerTrxId(UUID.randomUUID().toString());
        zrSyncafaResult.setErrMsg("aaa");
        zrSyncafaResult.setIsClose(0);
        zrSyncafaResult.setIsDel(0);
        zrSyncafaResult.setStatus("22");
        zrSyncafaResult.setUniqueBusinessId(UUID.randomUUID().toString());
        zrSyncafaResult.setTrxNumber("bbb");

        ZrSyncafaResult result = new ZrSyncafaResult();
        result.setCreateTime(new Date());
        result.setCustomerTrxId(UUID.randomUUID().toString());
        result.setErrMsg("aaa");
        result.setIsClose(0);
        result.setIsDel(0);
        result.setStatus("22");
        result.setUniqueBusinessId(UUID.randomUUID().toString());
        result.setTrxNumber("bbb");

        ZrSyncafaResult syncafaResult = new ZrSyncafaResult();
        syncafaResult.setCreateTime(new Date());
        syncafaResult.setCustomerTrxId(UUID.randomUUID().toString());
        syncafaResult.setErrMsg("aaa");
        syncafaResult.setIsClose(0);
        syncafaResult.setIsDel(0);
        syncafaResult.setStatus("22");
        syncafaResult.setUniqueBusinessId(UUID.randomUUID().toString());
        syncafaResult.setTrxNumber("bbb");

        list.add(zrSyncafaResult);
        list.add(result);
        list.add(syncafaResult);
        return list;
    }
}
