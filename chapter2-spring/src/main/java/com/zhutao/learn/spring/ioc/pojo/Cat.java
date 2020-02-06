package com.zhutao.learn.spring.ioc.pojo;

import com.zhutao.learn.spring.ioc.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 21:59
 * @Version 1.0
 */
@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫"+ Cat.class.getSimpleName() +"是抓老鼠用的");
    }
}
