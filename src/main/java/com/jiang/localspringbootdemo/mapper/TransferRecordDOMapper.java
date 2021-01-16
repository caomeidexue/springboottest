package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.TransferRecordDO;

public interface TransferRecordDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransferRecordDO record);

    int insertSelective(TransferRecordDO record);

    TransferRecordDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransferRecordDO record);

    int updateByPrimaryKey(TransferRecordDO record);
}