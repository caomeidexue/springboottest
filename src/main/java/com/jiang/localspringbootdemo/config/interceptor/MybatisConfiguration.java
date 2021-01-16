package com.jiang.localspringbootdemo.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-23 10:08
 * mybatis配置
 */
//@Configuration
public class MybatisConfiguration {
    /**
     * 注册拦截器
     */
    @Bean
    public MybatisInterceptor mybatisInterceptor() {
        MybatisInterceptor interceptor = new MybatisInterceptor();
        Properties properties = new Properties();
        // 可以调用properties.setProperty方法来给拦截器设置一些自定义参数
        interceptor.setProperties(properties);
        return interceptor;
    }

}
