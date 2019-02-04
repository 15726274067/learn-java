package com.zhutao.ioc.pojo;

import com.zhutao.ioc.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 21:15
 * @Version 1.0
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗"+ Dog.class.getSimpleName() +"是看门用的");
    }
}
