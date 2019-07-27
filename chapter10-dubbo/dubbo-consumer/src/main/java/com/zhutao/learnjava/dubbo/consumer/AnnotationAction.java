package com.zhutao.learnjava.dubbo.consumer;

import com.zhutao.learnjava.dubbo.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 15:04
 * @Version 1.0
 */
@Component("annotationAction")
public class AnnotationAction {

    @Reference
    private HelloService helloService;

    public String sayHello(String name) {
        return helloService.sayHello(name);
    }
}
