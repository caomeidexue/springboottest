package com.jiang.localspringbootdemo.config.testautowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 14:40
 */
@Component
@ConfigurationProperties(prefix = "abstract" )
public class TestAutoWired {


    private String testAutoWiredString;


    public String getTestAutoWiredString() {
        return testAutoWiredString;
    }

    public void setTestAutoWiredString(String testAutoWiredString) {
        this.testAutoWiredString = testAutoWiredString;
    }
}
