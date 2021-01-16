package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.LayOutDO;

public interface LayOutDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LayOutDO record);

    int insertSelective(LayOutDO record);

    LayOutDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LayOutDO record);

    int updateByPrimaryKeyWithBLOBs(LayOutDO record);

    int updateByPrimaryKey(LayOutDO record);
}