package com.zhutao.learn.dubbo.provider1;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 20:57
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zhutao.learnjava.dubbo.provider1")
@EnableDubbo(scanBasePackages = "com.zhutao.learnjava.dubbo.provider1.impl")
public class DubboProvider1App {
    public static void main(String[] args) {
        SpringApplication.run(DubboProvider1App.class);
    }
}
