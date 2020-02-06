package com.zhutao.learn.spring.aop.intercept;

import com.zhutao.learn.spring.aop.invoke.MyInvocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 15:39
 * @Version 1.0
 */
public interface Interceptor {
    // 事前方法
    boolean before();

    // 事后方法
    void after();

    /**
     * 环绕方法
     * 取代原有事件方法
     * @param invocation 一回调参数 ，可以通过它的 proceed 方法,回调原有事件
     * @return 原有事件返回对象
     */
    Object around(MyInvocation invocation) throws InvocationTargetException, IllegalAccessException;

    // 正常返回方法
    void afterReturning();

    // 有异常抛出方法
    void afterThrowing();

    // 是否使用环绕方法
    boolean useAround();
}
