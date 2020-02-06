package com.zhutao.learn.spring.ioc.config;

import com.zhutao.learn.spring.ioc.pojo.Book;
import com.zhutao.learn.spring.ioc.pojo.DataBaseProperties;
import com.zhutao.learn.spring.ioc.pojo.DataBaseProperties2;
import com.zhutao.learn.spring.ioc.pojo.User;
import com.zhutao.learn.spring.ioc.pojo.definition.Person;
import com.zhutao.learn.spring.ioc.service.impl.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: zhutao
 * @Date: 2019/1/31 17:37
 * @Version 1.0
 */
@SpringBootApplication
public class IocTest {
    public static void main(String[] args){
        /**
         * AnnotationConfigApplicationContext: 使用注解创建ApplicationContext
         * 这里将配置文件AppConfig类传给spring, 会把配置里边的bean装配到spring中
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        User user = (User) context.getBean("user");
        User user = context.getBean(User.class);
        System.out.println(user);

        /**
         * 如果bean没有装配到spring,在试图获得对象时会报错
         * org.springframework.beans.factory.NoSuchBeanDefinitionException:
         * No qualifying bean of type 'Book' available
         */
        Book book = context.getBean(Book.class);
        System.out.println(book);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getById());

        Person person = context.getBean(Person.class);
        person.service();

        DataBaseProperties dataBaseProperties = context.getBean(DataBaseProperties.class);
        System.out.println(dataBaseProperties.toString());

        DataBaseProperties2 dataBaseProperties2 = context.getBean(DataBaseProperties2.class);
        System.out.println(dataBaseProperties2.toString());
    }
}
