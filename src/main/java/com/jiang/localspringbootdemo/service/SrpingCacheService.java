package com.jiang.localspringbootdemo.service;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;

import java.util.List;

public interface SrpingCacheService {
    OtimisticLockAccount getById(int i);

    void delCache(int i);

    List<OtimisticLockAccount> getPoolDataList();
}
