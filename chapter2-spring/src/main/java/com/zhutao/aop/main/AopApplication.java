package com.zhutao.aop.main;

import com.zhutao.aop.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 18:42
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zhutao.aop")
public class AopApplication {

    // 定义切面
    @Bean("myAspect")
    public MyAspect initAspect(){
        return new MyAspect();
    }

    public static void main(String[] args){
        SpringApplication.run(AopApplication.class);
    }
}
