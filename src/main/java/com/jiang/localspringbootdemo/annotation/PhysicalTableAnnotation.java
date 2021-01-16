package com.jiang.localspringbootdemo.annotation;

import java.lang.annotation.*;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-22 16:51
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhysicalTableAnnotation {

    //表名
    public String tableName();
    //类型
    public Class type();
}
