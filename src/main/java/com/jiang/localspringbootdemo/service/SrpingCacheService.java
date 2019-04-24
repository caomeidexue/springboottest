package com.jiang.localspringbootdemo.service;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;

public interface SrpingCacheService {
    OtimisticLockAccount getById(int i);

    void delCache(int i);
}
