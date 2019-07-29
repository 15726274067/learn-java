package com.zhutao.learnjava.dubbo.consumer.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.*;

/**
 * @Author: zhutao
 * @Date: 2019-07-25 15:07
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = { "com.zhutao.learnjava.dubbo.consumer" })
@PropertySource("classpath:/application.properties")
@EnableDubbo(scanBasePackages = "com.zhutao.learnjava.dubbo.consumer")
public class ConsumerConfiguration {

}
