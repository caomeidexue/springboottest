package com.jiang.localspringbootdemo.config.aopconfig;

import com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation;
import org.apache.ibatis.plugin.Invocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author jqb
 * @Description
 * @Date 2020-04-22 17:14
 */
@Component
@Aspect
public class PhysicalTableAnnotationAop  {


    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("@annotation(com.jiang.localspringbootdemo.annotation.PhysicalTableAnnotation)")
    public void BrokerAspect(){

    }


    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @Before(value = "BrokerAspect() && @annotation(physicalTableAnnotation) && execution(* com.jiang.localspringbootdemo.mapper.*.*(..))" ,argNames = "jp,physicalTableAnnotation")
    public void doAfterGame(JoinPoint jp,PhysicalTableAnnotation physicalTableAnnotation) throws Exception{

        final String tableName = physicalTableAnnotation.tableName();
        //得到被代理的方法
        Object target = jp.getTarget();
        String method = jp.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        Signature sign=jp.getSignature();
        MethodSignature msgin=(MethodSignature) sign;
        Class<?>[] parameterTypes = msgin.getMethod().getParameterTypes();
        Method me = classz[0].getMethod(method, parameterTypes);

        if(me.getAnnotation(PhysicalTableAnnotation.class) != null) {
            String key =me.getAnnotation(PhysicalTableAnnotation.class).tableName();

            System.out.println(key);

        }else {
            System.out.println("没有");
        }


    }


    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @Around(value = "execution(* com.jiang.localspringbootdemo.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();
        //得到其方法签名
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        //获取方法参数类型数组
        Class[] paramTypeArray = methodSignature.getParameterTypes();

        Object result = null;
        try {
            result = joinPoint.proceed(args);
        } catch (Throwable throwable) {
            System.out.println("切面异常了");
            System.out.println(throwable);
            throw throwable;
        }
        return result;



    }

    @AfterThrowing(value = "execution(* com.jiang.localspringbootdemo.service.*.*(..))")
    public void afterThrowing(JoinPoint joinPoint) throws Throwable {

        //获取方法参数值数组
        Object[] args = joinPoint.getArgs();

        System.out.println(args);



    }


}
