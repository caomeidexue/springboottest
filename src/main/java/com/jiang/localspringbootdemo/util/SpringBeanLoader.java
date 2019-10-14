package com.jiang.localspringbootdemo.util;

import org.springframework.context.ApplicationContext;

/**
 * @Author jiangqb
 * @Description
 * @Date 2019-10-14 14:48
 */

public class SpringBeanLoader {


    private static ApplicationContext applicationContext;

    /**
     * 获取SpringApplicationContext
     *
     * @return ApplicationContext
     */

    private static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 设置SpringApplicationContext
     *
     * @param applicationContext
     */
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringBeanLoader.applicationContext = applicationContext;
    }

    /**
     * 获取Spring中注册的Bean
     *
     * @param beanClass
     * @param beanId
     * @return
     */
    public static <T> T getSpringBean(String beanId, Class<T> beanClass) {
        return getApplicationContext().getBean(beanId, beanClass);
    }

    /**
     * 获取Spring中注册的Bean
     *
     * @param beanClass
     * @return
     */
    public static <T> T getSpringBean(Class<T> beanClass) {
        return getApplicationContext().getBean(beanClass);
    }
}
