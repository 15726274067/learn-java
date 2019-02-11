package com.zhutao.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 19:29
 * @Version 1.0
 */
@Aspect
@Order(3)
public class Aspect3 {

    @Pointcut("execution(* com.zhutao.aop.service.impl.HelloServiceImpl.manyAspects (..))")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void before(){
        System.out.println("aspect3 before" + Aspect3.class.getSimpleName());
    }

    @After("pointcut()")
    public void after(){
        System.out.println("aspect3 after" + Aspect3.class.getSimpleName());
    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning(){
        System.out.println("aspect3 afterReturning" + Aspect3.class.getSimpleName());
    }

}
