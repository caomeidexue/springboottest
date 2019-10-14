package com.jiang.localspringbootdemo.mapper;

import com.jiang.localspringbootdemo.entity.OtimisticLockAccount;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OtimisticLockAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OtimisticLockAccount record);

    int insertSelective(OtimisticLockAccount record);

    OtimisticLockAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OtimisticLockAccount record);

    int updateByPrimaryKey(OtimisticLockAccount record);

    List<OtimisticLockAccount> getList();
}