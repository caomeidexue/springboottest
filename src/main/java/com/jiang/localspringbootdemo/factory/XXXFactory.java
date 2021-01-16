package com.jiang.localspringbootdemo.factory;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author jqb
 * @Description
 * @Date 2020-06-05 17:40
 */
@Component
public class XXXFactory implements InitializingBean {

    @Autowired
    private List<IHandler> handlerList;

    private Map<Integer,IHandler> handlerMap;

    protected Integer getOrgerType(IHandler handler){
        return handler.getOrderType();
    }

    public IHandler getHandler(Integer orderTyep){
        return handlerMap.get(orderTyep);
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(handlerList)){
            throw new RuntimeException("处理器不能为空");
        }
        handlerMap= Maps.newHashMap();

        this.handlerList.stream().forEach(handler ->{
            handlerMap.put(getOrgerType(handler),handler);
        });
    }
}
