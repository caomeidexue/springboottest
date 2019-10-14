package com.jiang.localspringbootdemo.config.testautowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 14:40
 */

@Configuration

public class TestAutoWired {

    @Value("abstract.valuetest")
    private String testAutoWiredString;


    public String getTestAutoWiredString() {
        return testAutoWiredString;
    }

    public void setTestAutoWiredString(String testAutoWiredString) {
        this.testAutoWiredString = testAutoWiredString;
    }
}
