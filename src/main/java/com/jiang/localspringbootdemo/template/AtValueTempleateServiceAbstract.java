package com.jiang.localspringbootdemo.template;

import com.jiang.localspringbootdemo.config.testautowired.TestAutoWired;
import com.jiang.localspringbootdemo.template.AtValueTempleateService;
import com.jiang.localspringbootdemo.util.SpringBeanLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 11:12
 */
@Service
public abstract class AtValueTempleateServiceAbstract implements AtValueTempleateService {

    @Value("abstract.valuetest")
    private String testValue;


    //抽象类里面bean无法注入,需要从应用上下文中显示获取
    /*
    @Autowired
    private TestAutoWired testAutoWired;*/

    private TestAutoWired testAutoWired  = SpringBeanLoader.getSpringBean(TestAutoWired.class);




    @Override
    public String getTestValue() {

        String testAutoWiredString = testAutoWired.getTestAutoWiredString();
        return testAutoWiredString;
    }

    protected abstract String getVlaue();
}
