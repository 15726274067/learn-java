package com.zhutao.learn.spring.aop;

import com.zhutao.learn.spring.aop.intercept.MyInterceptor;
import com.zhutao.learn.spring.aop.proxy.ProxyBean;
import com.zhutao.learn.spring.aop.service.HelloService;
import com.zhutao.learn.spring.aop.service.impl.HelloServiceImpl;

/**
 * @Author: zhutao
 * @Date: 2019/2/4 17:36
 * @Version 1.0
 */
public class App {
    public static void main(String[] args){
        HelloService helloService = new HelloServiceImpl();

        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());

        proxy.sayHello("aaa");
    }
}
