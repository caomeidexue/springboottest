package com.jiang.localspringbootdemo.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @program: zfbankdirectzs
 * @description: 数据源配置
 * @author: jiiangqb@ziroom.com
 * @create: 2018-06-27 11:57
 **/
@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.driverClassName}")
    private String  driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public DataSource getDataSource(){
        return initDataSource();
    }


    public DataSource initDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setMaxActive(30);
        dataSource.setMaxWait(10000);
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }


}

    
