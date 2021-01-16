package com.jiang.localspringbootdemo.service.impl;

import com.jiang.localspringbootdemo.model.LayOutSaveDTO;
import com.jiang.localspringbootdemo.service.LayOutTransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-04 15:13
 */
@Transactional
@Service
public class LayOutTransactionServiceImpl implements LayOutTransactionService {

    /**
     *
     * @param layOutSaveDTO
     */
    @Override
    public void saveAll(LayOutSaveDTO layOutSaveDTO) {

    }
}
