package com.zhutao.aop.proxy;

import com.zhutao.aop.intercept.Interceptor;
import com.zhutao.aop.invoke.MyInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 17:19
 * @Version 1.0
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    /**
     * JDK动态代理 生成proxy
     * @param target
     * @param interceptor
     * @return
     */
    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;

        /**
         * • classLoader 类加载器
         * • interfaces 绑定的接口,也就是把代理对象绑定到哪些接口下 ,可以是多个
         * • invocationHandler -- 绑定代理对象逻辑实现
         *     这里的 invocationHandler 是一个接口 InvocationHandler 对象,它定义了一个 invoke 方法
         *     这个方法就是实现代理对象的逻辑的
         */
        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                proxyBean);
        return proxy;
    }

    /**
     * 使用代理对象,调用方法时,会进入到这里
     * 动态代理的核心
     * @param proxy
     * @param method
     * @param args
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        boolean exceptFlag = false;
        MyInvocation myInvocation = new MyInvocation(args, method, target);
        Object result = null;

        try {
            if(this.interceptor.before()){
                result = this.interceptor.around(myInvocation);
            } else {
                result = method.invoke(target, args);
            }
        } catch (Exception e){
            e.printStackTrace();
            exceptFlag = true;
        }

        this.interceptor.after();

        if (exceptFlag) {
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
            return result;
        }
        return null;
    }
}
