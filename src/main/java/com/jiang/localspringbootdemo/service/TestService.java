package com.jiang.localspringbootdemo.service;

public interface TestService {
    void insert();

    void batchInsert();

    void batchUpdate();

    void updateOne();

    void insertBatchAndReturnKey();
}
