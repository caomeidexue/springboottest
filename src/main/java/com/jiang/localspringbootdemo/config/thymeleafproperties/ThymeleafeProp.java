package com.jiang.localspringbootdemo.config.thymeleafproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @Author jiangqb
 * @Description
 * @Date 2020-01-15 10:55
 */
//@ConfigurationProperties(prefix = "spring.thymeleaf")
//@Component
public class ThymeleafeProp {


    public static final String DEFAULT_PREFIX = "classpath:/templates/";
    public static final String DEFAULT_SUFFIX = ".html";


    public static String getDefaultPrefix() {
        return DEFAULT_PREFIX;
    }

    public static String getDefaultSuffix() {
        return DEFAULT_SUFFIX;
    }
}
