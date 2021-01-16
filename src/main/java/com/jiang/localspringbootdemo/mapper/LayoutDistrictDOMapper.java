package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.LayoutDistrictDO;

public interface LayoutDistrictDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LayoutDistrictDO record);

    int insertSelective(LayoutDistrictDO record);

    LayoutDistrictDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LayoutDistrictDO record);

    int updateByPrimaryKeyWithBLOBs(LayoutDistrictDO record);

    int updateByPrimaryKey(LayoutDistrictDO record);
}