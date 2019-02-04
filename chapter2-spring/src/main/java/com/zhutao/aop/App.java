package com.zhutao.aop;

import com.zhutao.aop.intercept.MyInterceptor;
import com.zhutao.aop.proxy.ProxyBean;
import com.zhutao.aop.service.HelloService;
import com.zhutao.aop.service.impl.HelloServiceImpl;

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
