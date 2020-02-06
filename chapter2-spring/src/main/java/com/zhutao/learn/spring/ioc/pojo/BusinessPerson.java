package com.zhutao.learn.spring.ioc.pojo;

import com.zhutao.learn.spring.ioc.pojo.definition.Animal;
import com.zhutao.learn.spring.ioc.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 21:14
 * @Version 1.0
 */
@Component
public class BusinessPerson implements Person {

    /**
     * Autowired注解: 根据类型(默认),找到合适的对象进行注入
     * 这里是在直接属性上注入
     * Qualifier注解: 根据名称,找到要注入的对象
     */
    @Autowired
    @Qualifier("dog")
    private Animal animal = null;


    /**
     * 通过带参构造函数进行注入
     */
    private Animal animal1 = null;

    public BusinessPerson(@Autowired @Qualifier("cat") Animal animal1) {
        this.animal1 = animal1;
    }

    public void setAnimal1(Animal animal1) {
        this.animal1 = animal1;
    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
