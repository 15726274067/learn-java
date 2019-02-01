package com.zhutao.config;

import com.zhutao.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ＠Configuration 代表这是一个 Java 配置文件,Spring 的容器会根据
 * 它来生成 IoC 容器去装配 Bean;
 * @Author: zhutao
 * @Date: 2019/1/31 17:33
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = { "com.zhutao" })
public class AppConfig {

    /**
     * 将bean装配到spring的第一种方法
     * 将 initUser 方法返回的 POJO 装配到 IoC 容器中 @Bean注解
     * 如果没有配置,则将方法名称“initUser”作为 Bean 的名称保存到 Spring IoC 容器中
     * @return
     */
    @Bean(name = "user")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setName("zhutao");
        user.setNote("note_1");
        return user;
    }

    /**
     * 自定义第三方bean
     * 这里是把dbcp datasource 引进spring中
     */
//    @Bean("dataSource")
//    public DataSource getDataSource(){
//        Properties prop = new Properties();
//        prop.setProperty("driver", "com.mysql.jdbc.Driver");
//        prop.setProperty("url", "jdbc:mysql://localhost:3306/test");
//        prop.setProperty("username", "admin");
//        prop.setProperty("password", "qwe121324");
//        DataSource dataSource = null ;
//        try {
//            dataSource = BasicDataSourceFactory.createDataSource(prop);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
}
