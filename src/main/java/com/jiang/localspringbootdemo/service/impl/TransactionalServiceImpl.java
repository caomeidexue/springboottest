package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import com.jiang.localspringbootdemo.mapper.OtimisticLockAccountMapper;
import com.jiang.localspringbootdemo.mapper.ZrSyncafaResultMapper;
import com.jiang.localspringbootdemo.service.OtimisticLockAccountService;
import com.jiang.localspringbootdemo.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-11-28 17:35
 */

@Service
public class TransactionalServiceImpl implements TransactionalService {


    @Autowired
    private OtimisticLockAccountService otimisticLockAccountService;


    @Autowired
    private ZrSyncafaResultMapper zrSyncafaResultMapper;


    @Override
    @Transactional
    public void testInsertTransaction() {
        ZrSyncafaResult zrSyncafaResult = new ZrSyncafaResult();
        zrSyncafaResult.setCreateTime(new Date());
        zrSyncafaResult.setCustomerTrxId("1111");
        zrSyncafaResult.setErrMsg("测试事物");
        zrSyncafaResult.setIsClose(1);
        zrSyncafaResult.setIsDel(0);
        zrSyncafaResult.setTrxNumber("123");
        zrSyncafaResult.setUniqueBusinessId("123");
        zrSyncafaResult.setStatus("b");
        zrSyncafaResultMapper.insertSelective(zrSyncafaResult);
        //throw new RuntimeException("aaaa");
        insetOther();

    }

    private void insetOther() {
        OtimisticLockAccount otimisticLockAccount = new OtimisticLockAccount();
        otimisticLockAccount.setRemark("测试");
        otimisticLockAccount.setLastModifyTime(new Date());
        otimisticLockAccount.setAmount(1);
        otimisticLockAccount.setVersionAmount(2);
        otimisticLockAccount.setUniqueid("aaa");
        otimisticLockAccount.setCucurrentVersionAmount(10);
        otimisticLockAccountService.insert(otimisticLockAccount);
        throw new RuntimeException("cccc");
    }
}
