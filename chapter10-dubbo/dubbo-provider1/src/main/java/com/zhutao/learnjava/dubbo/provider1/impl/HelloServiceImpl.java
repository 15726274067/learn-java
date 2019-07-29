package com.zhutao.learnjava.dubbo.provider1.impl;

import com.zhutao.learnjava.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 20:55
 * @Version 1.0
 */
@Service
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return name + "provider1";
    }
}
