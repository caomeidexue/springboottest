package com.jiang.localspringbootdemo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.jiang.localspringbootdemo.util.SpringBeanLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDubboConfiguration
@EnableCaching
public class LocalspringbootdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LocalspringbootdemoApplication.class, args);

        SpringBeanLoader.setApplicationContext(run);
    }

}

