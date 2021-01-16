package com.jiang.localspringbootdemo.config.interceptor;

import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import com.mysql.jdbc.Connection;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-23 10:10
 */
@Component
@MapperScan("com.jiang.localspringbootdemo.mapper")
@Intercepts({
        @Signature(
                type = StatementHandler.class, method = "prepare",
                args = {Connection.class, Integer.class}),
        @Signature(type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class,
                        CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})

})

public class MybatisInterceptor implements Interceptor {


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        final Object[] args = invocation.getArgs();

        final Method method = invocation.getMethod();
        final PhysicalTableAnnotation annotation = method.getAnnotation(PhysicalTableAnnotation.class);
        System.out.println(annotation);
        return null;
    }

    @Override
    public Object plugin(Object o) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
