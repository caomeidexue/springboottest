package com.jiang.localspringbootdemo.service;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;

public interface OtimisticLockAccountService {
    int updateData(int i, int i1,int id);

    int updateDataWitDistructLock(int i, int i1, int i2);

    void insert(OtimisticLockAccount otimisticLockAccount);
}
