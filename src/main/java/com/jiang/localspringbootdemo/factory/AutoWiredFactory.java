package com.jiang.localspringbootdemo.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author jqb
 * @Description
 * @Date 2020-06-06 20:53
 */
@Component
public class AutoWiredFactory<Dto> {

    private Map<Integer,IHandler> map = new HashMap<>();

    @Autowired
    public AutoWiredFactory(List<IHandler> handlerList) {
        for (IHandler handler:handlerList) {
            map.put(handler.getOrderType(),handler);
        }
    }


    public void execute(Integer orderType,Dto dto){
        map.get(orderType).execute(dto);
    }
}
