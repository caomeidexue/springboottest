package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.TransferRecordItemDO;

public interface TransferRecordItemDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransferRecordItemDO record);

    int insertSelective(TransferRecordItemDO record);

    TransferRecordItemDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransferRecordItemDO record);

    int updateByPrimaryKey(TransferRecordItemDO record);
}