package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.SortingTask;

public interface SortingTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SortingTask record);

    int insertSelective(SortingTask record);

    SortingTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SortingTask record);

    int updateByPrimaryKey(SortingTask record);
}