package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.LayoutEquipmentDO;

public interface LayoutEquipmentDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LayoutEquipmentDO record);

    int insertSelective(LayoutEquipmentDO record);

    LayoutEquipmentDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LayoutEquipmentDO record);

    int updateByPrimaryKeyWithBLOBs(LayoutEquipmentDO record);

    int updateByPrimaryKey(LayoutEquipmentDO record);
}