package com.zhutao.config;

import com.zhutao.pojo.Book;
import com.zhutao.pojo.User;
import com.zhutao.pojo.definition.Person;
import com.zhutao.service.UserService;
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
         * 这里将配置文件AppConfig类传给spring, 会把配置里边的bean装配到spring中
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        User user = (User) context.getBean("user");
        User user = context.getBean(User.class);
        System.out.println(user);

        /**
         * 如果bean没有装配到spring,在试图获得对象时会报错
         * org.springframework.beans.factory.NoSuchBeanDefinitionException:
         * No qualifying bean of type 'com.zhutao.pojo.Book' available
         */
        Book book = context.getBean(Book.class);
        System.out.println(book);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getById());

        Person person = context.getBean(Person.class);
        person.service();
    }
}
