package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import com.jiang.localspringbootdemo.entity.ZrSyncafaResult;
import com.jiang.localspringbootdemo.entity.ZrSyncafaResultUpdateDo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZrSyncafaResultMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ZrSyncafaResult record);

    int insertSelective(ZrSyncafaResult record);

    ZrSyncafaResult selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZrSyncafaResult record);

    int updateByPrimaryKey(ZrSyncafaResult record);

    List<ZrSyncafaResult> selectAll();

    int batchUpdate(@Param("list") List<ZrSyncafaResultUpdateDo> list);

    @PhysicalTableAnnotation(tableName = "zr_syncafa_result",type =ZrSyncafaResultMapper.class)
    int batchInsertOnUpdate(List<ZrSyncafaResult> list);
}