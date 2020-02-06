package com.zhutao.learn.spring.ioc.pojo;

import com.zhutao.learn.spring.ioc.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 21:15
 * @Version 1.0
 */
//@Profile("dev")
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗"+ Dog.class.getSimpleName() +"是看门用的");
    }
}
