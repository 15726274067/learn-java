package com.zhutao.aop.intercept;

import com.zhutao.aop.invoke.MyInvocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:49
 * @Version 1.0
 */
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before... " + this.getClass().getName());
        return this.useAround();
    }

    @Override
    public void after() {
        System.out.println("after... " + this.getClass().getName());
    }

    @Override
    public Object around(MyInvocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before... " + this.getClass().getName());

        Object o = invocation.proceed();

        System.out.println("around after... " + this.getClass().getName());
        return o;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning... " + this.getClass().getName());

    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing... " + this.getClass().getName());

    }

    @Override
    public boolean useAround() {
        return true;
    }
}
