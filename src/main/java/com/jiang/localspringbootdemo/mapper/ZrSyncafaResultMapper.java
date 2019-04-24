package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import org.springframework.stereotype.Repository;

@Repository
public interface ZrSyncafaResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZrSyncafaResult record);

    int insertSelective(ZrSyncafaResult record);

    ZrSyncafaResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZrSyncafaResult record);

    int updateByPrimaryKey(ZrSyncafaResult record);
}