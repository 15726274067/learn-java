package com.zhutao.learn.spring.aop.main;

import com.zhutao.learn.spring.aop.aspect.Aspect1;
import com.zhutao.learn.spring.aop.aspect.Aspect2;
import com.zhutao.learn.spring.aop.aspect.Aspect3;
import com.zhutao.learn.spring.aop.aspect.MyAspect;
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

    /**
     * 定义切面
     *
     * 开发者需要确定切面的执行顺序, 来决定哪些切面先执行，哪些切面后执行
     * 为此, Spring 提供了一个注解＠Order 和一个接口 Ordered
     * 我们可以使用它们的任意一个指定切面的顺序
     *
     * 前置通知(before)都是从小到大运行的,而对于后置通知和返回通知都是
     * 从大到小运行的,这就是一个典型的责任链模式的顺序
     * @return
     */
    @Bean("myAspect")
    public MyAspect initAspect(){
        return new MyAspect();
    }


    @Bean("aspect1")
    public Aspect1 initAspect1(){
        return new Aspect1();
    }
    @Bean("aspect2")
    public Aspect2 initAspect2(){
        return new Aspect2();
    }

    @Bean("aspect3")
    public Aspect3 initAspect3(){
        return new Aspect3();
    }

    public static void main(String[] args){
        SpringApplication.run(AopApplication.class);
    }
}
