package com.zhutao.learn.spring.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zhutao
 * @Date: 2019/2/18 16:06
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zhutao.learn.spring")

public class IoCApplication {
    public static void main( String[] args ) {
        SpringApplication.run(IoCApplication.class);
    }
}
