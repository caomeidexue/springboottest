package com.jiang.localspringbootdemo.service;

public interface OtimisticLockAccountService {
    int updateData(int i, int i1,int id);

    int updateDataWitDistructLock(int i, int i1, int i2);
}
