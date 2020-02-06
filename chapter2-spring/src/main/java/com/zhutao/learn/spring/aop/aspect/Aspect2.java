package com.zhutao.learn.spring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 19:29
 * @Version 1.0
 */
@Aspect
@Order(2)
public class Aspect2 {

    @Pointcut("execution(* com.zhutao.learn.spring.aop.service.impl.HelloServiceImpl.manyAspects (..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(){
        System.out.println("aspect2 before" + Aspect2.class.getSimpleName());
    }

    @After("pointcut()")
    public void after(){
        System.out.println("aspect2 after" + Aspect2.class.getSimpleName());
    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning(){
        System.out.println("aspect2 afterReturning" + Aspect2.class.getSimpleName());
    }

}
