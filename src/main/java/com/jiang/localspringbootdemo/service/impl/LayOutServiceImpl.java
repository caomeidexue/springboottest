package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.mapper.LayOutDOMapper;
import com.jiang.localspringbootdemo.model.LayOutSaveDTO;
import com.jiang.localspringbootdemo.service.LayOutService;
import com.jiang.localspringbootdemo.service.LayOutTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-04 14:36
 */

@Service
public class LayOutServiceImpl implements LayOutService {


    @Autowired
    private LayOutTransactionService layOutTransactionService;



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveLayOut(LayOutSaveDTO layOutSaveDTO) {
        //参数校验
        layOutTransactionService.saveAll(layOutSaveDTO);
    }
}
