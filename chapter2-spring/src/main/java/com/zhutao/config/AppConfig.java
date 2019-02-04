package com.zhutao.config;

import com.zhutao.pojo.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Properties;

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
     *
     * 条件装配
     * 某些情况下不希望Ioc去进行bean的自动装配
     * 见package com.zhutao.condition
     * 条件装配如果错过自动装配,如何处理?
     *
     * bean的作用域
     */
    @Bean(value = "dataSource")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSource getDataSource(
            @Value("${database.driverName}") String driverName,
            @Value("${database.url}") String url,
            @Value("${database.username}") String username,
            @Value("${database.password}") String password){
        Properties prop = new Properties();
        prop.setProperty("driver", driverName);
        prop.setProperty("url", url);
        prop.setProperty("username", username);
        prop.setProperty("password", password);
        DataSource dataSource = null ;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}