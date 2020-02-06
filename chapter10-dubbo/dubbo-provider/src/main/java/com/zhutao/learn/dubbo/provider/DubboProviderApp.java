package com.zhutao.learn.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 11:48
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zhutao.learnjava.dubbo.provider")
@EnableDubbo(scanBasePackages = "com.zhutao.learnjava.dubbo.provider.impl")
public class DubboProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApp.class);
    }
}
