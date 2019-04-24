package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import com.jiang.localspringbootdemo.mapper.OtimisticLockAccountMapper;
import com.jiang.localspringbootdemo.service.SrpingCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SrpingCacheServiceImpl implements SrpingCacheService {

    @Autowired
    private OtimisticLockAccountMapper otimisticLockAccountMapper;


    @Override
    @Cacheable(value = "usr" ,key = "#root.targetClass" ,unless = "#result eq null")
    public OtimisticLockAccount getById(int i) {

                OtimisticLockAccount  aa = otimisticLockAccountMapper.selectByPrimaryKey(i);
                return aa;
    }



    @Override
    @CacheEvict(value = "usr",key ="#root.targetClass")
    public void delCache(int i) {
        OtimisticLockAccount  aa = otimisticLockAccountMapper.selectByPrimaryKey(i);
        aa.setAmount(10000);
        aa.setLastModifyTime(new Date());
        aa.setRemark("测试更新");
        otimisticLockAccountMapper.updateByPrimaryKeySelective(aa);
    }
}
