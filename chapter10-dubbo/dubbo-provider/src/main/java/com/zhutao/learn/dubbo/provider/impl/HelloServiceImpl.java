package com.zhutao.learn.dubbo.provider.impl;

import com.zhutao.learn.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 11:44
 * @Version 1.0
 */
@Component
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "1111";
    }
}
