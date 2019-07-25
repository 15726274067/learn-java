package com.zhutao.learnjava.dubbo.consumer;

import com.zhutao.learnjava.dubbo.consumer.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 16:46
 * @Version 1.0
 */
public class ConsumerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        String hello = annotationAction.sayHello("world");

        System.out.println(hello);
    }
}
