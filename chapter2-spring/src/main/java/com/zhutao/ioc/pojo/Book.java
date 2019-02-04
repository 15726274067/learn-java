package com.zhutao.ioc.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 装配bean的第二种方式<br/>
 * Component注解与ComponentScan进行配合<br/>
 * Component 标识bean可以被装配进spring, 默认name为className首字母小写,其他不变, 也可以通过name指定bean名称<br/>
 * ComponentScan 指定扫描的策略,扫描到的bean才会被装配<br/>
 * @Author: zhutao
 * @Date: 2019/1/31 17:46
 * @Version 1.0
 */
@Component(value = "book")
public class Book implements BeanNameAware,
        BeanFactoryAware,
        ApplicationContextAware,
        InitializingBean,
        DisposableBean {
    @Value("1")
    private Long id;

    @Value("book1")
    private String name;

    @Value("this is book1")
    private String desc;

    public Book() {
    }

    public Book(Long id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 1. 设置bean的名称
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware" + s);
    }

    /**
     * 2. 设置beanFactory
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware" + beanFactory.toString());
    }

    /**
     * 3. 设置applicationContext
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware" + applicationContext.toString());
    }


    /**
     * 5. bean构造完成后
     */
    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct");
    }

    /**
     * 6. bean属性赋值后调用
     */
    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean");

    }

    /**
     * 8. bean销毁前
     */
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy");
    }

    /**
     * 9. bean销毁后
     */
    @Override
    public void destroy() {
        System.out.println("DisposableBean");
    }

}
