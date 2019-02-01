package com.zhutao.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置bean初始化器
 * 将对所有bean有效
 * @Author: zhutao
 * @Date: 2019/2/1 23:04
 * @Version 1.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    /**
     * 4. bean的公共预初始化方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization beanName:" + beanName);
        return bean;
    }

    /**
     * 7. bean的公共后初始化方法
     * 执行后进入生存期
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization beanName: " + beanName);
        return bean;
    }
}
