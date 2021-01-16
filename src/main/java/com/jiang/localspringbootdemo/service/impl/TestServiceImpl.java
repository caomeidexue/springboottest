package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import com.jiang.localspringbootdemo.entity.ZrSyncafaResultUpdateDo;
import com.jiang.localspringbootdemo.mapper.ZrSyncafaResultMapper;
import com.jiang.localspringbootdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
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


    @Override
    public void batchUpdate() {
       // this.batchInsert();
        List<ZrSyncafaResult> zrSyncafaResults = zrSyncafaResultMapper.selectAll();

        List<ZrSyncafaResultUpdateDo>  updates = new ArrayList<>();

        zrSyncafaResults.forEach(zrSyncafaResult -> {
            ZrSyncafaResultUpdateDo aDo = new ZrSyncafaResultUpdateDo();
            aDo.setId(zrSyncafaResult.getId());
            aDo.setStatus("测试222"+new Random().nextInt());
            aDo.setLastModifyTime(new Date());
            aDo.setErrMsg("错误信息"+new Random().nextInt());
            aDo.setStatus("11");
            updates.add(aDo);
        });


        final int i = zrSyncafaResultMapper.batchUpdate(updates);
        System.out.println(i);
    }


    @Override
    public void updateOne() {

    }


    @Override
    public void insertBatchAndReturnKey() {


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
        System.out.println(1);

    }
}
