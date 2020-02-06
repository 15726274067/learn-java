package com.zhutao.learn.spring.aop.aspect;

import com.zhutao.learn.spring.aop.validator.HelloValidator;
import com.zhutao.learn.spring.aop.validator.impl.HelloValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 18:24
 * @Version 1.0
 */
@Aspect
public class MyAspect {

    /**
     * 使用注解@Pointcut来定义切点
     *
     * • execution 表示在执行的时候,拦截里面的正则匹配的方法
     * • *表示任意返回类型的方法：
     * • HelloServiceImpl 指定目标对象的全限定名称
     * • printUser 指定目标对象的方法
     * • (..) 表示任意参数进行匹配。
     */
    @Pointcut("execution(* com.zhutao.learn.spring.aop.service.impl.HelloServiceImpl.print(..) )")
    public void pointcut(){

    }


    /**
     * 前置通知
     *
     * 获取参数
     * 1. args()
     */
    @Before("pointcut() && args(name)")
    public void before(String name){
        System.out.println("before..." + name);
    }

    /**
     * 获取参数
     * 2. 使用joinPoint的getArgs()
     * @param joinPoint
     */
    @After("pointcut()")
    public void after(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("after..." + Arrays.toString(args));
    }

    @AfterReturning(pointcut = "pointcut()")
    public void afterReturning(){
        System.out.println("AfterReturning...");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("AfterThrowing...");
    }

    /**
     * 环绕通知功能最为强大
     * 同时也最为难以控制
     * 使用场景是在你需要大幅度修改原有目标对象的服务逻辑时,否则都尽量使用其他的通知
     * 注意
     * 使用注解实现的环绕通知与使用xml实现,@Around与@Before执行顺序上存在差异
     * @param joinPoint
     * @throws Throwable
     */
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }

    /**
     * 在切面中使用@DeclareParents对原有对象进行增强
     * • value：指向你要增强功能的目标对象, 这里是要增强 HelloServiceImpl 对象
     * 配置为com.zhutao.aop.service.impl.HelloServiceImpl。
     * • defaultImpl：引入增强功能的类,这里配置为 HelloValidatorImpl,用来提供校验用户是否为空的功能
     */
    @DeclareParents(value = "com.zhutao.learn.spring.aop.service.impl.HelloServiceImpl",
            defaultImpl = HelloValidatorImpl.class)
    public HelloValidator helloValidator;
}
