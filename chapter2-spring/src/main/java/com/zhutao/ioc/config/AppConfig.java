package com.zhutao.ioc.config;

import com.zhutao.ioc.condition.DatabaseCondition;
import com.zhutao.ioc.filter.MyFilter;
import com.zhutao.ioc.pojo.User;
import com.zhutao.ioc.service.BookService;
import com.zhutao.ioc.service.OtherService;
import com.zhutao.ioc.service.impl.BookServiceImpl;
import com.zhutao.ioc.service.impl.OtherServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * ＠Configuration 代表这是一个 Java 配置文件,Spring 的容器会根据
 * 它来生成 IoC 容器去装配 Bean;
 *
 * 注解: @ComponentScan
 * 扫描指定的包下的bean,将其注入到spring中
 * 可以通过excludeFilters/includeFilters进行过滤
 * 使用includeFilters时,要将useDefaultFilters设为false,禁止使用默认过滤器
 * java8下时可重复注解: @Repeatable(ComponentScans.class)
 * 非Java8使用@ComponentScans()
 *
 * @Author: zhutao
 * @Date: 2019/1/31 17:33
 * @Version 1.0
 */
@Configuration
//@ComponentScan(basePackages = { "com.zhutao" },
//        excludeFilters = {
//        @ComponentScan.Filter( classes = { Controller.class }, type = FilterType.ANNOTATION)
//        },
//        includeFilters = {
//        @ComponentScan.Filter( classes = {User.class}, type = FilterType.ASSIGNABLE_TYPE),
//        @ComponentScan.Filter(classes = {MyFilter.class}, type = FilterType.CUSTOM)
//        },
//        useDefaultFilters = false)


@ComponentScan(basePackages = { "com.zhutao" })
public class AppConfig {

    /**
     * 将bean装配到spring的第一种方法
     * 将 initUser 方法返回的 POJO 装配到 IoC 容器中 @Bean注解
     * 如果没有配置,则将方法名称“initUser”作为 Bean 的名称保存到 Spring IoC 容器中
     * @return user
     */
    @Bean(name = "user")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setName("zhutao");
        user.setNote("note_1");
        System.out.println("init user");
        return user;
    }

    // 如果一个bean依赖另一个bean，则直接调用对应JavaConfig类中依赖bean的创建方法即可
    // 这里直接调用initUser()
    @Bean
    public BookService bookService() {
        User user = initUser();
        return new BookServiceImpl(user);
    }

    @Bean
    public OtherService otherService() {
        User user = initUser();
        return new OtherServiceImpl(user);
    }


    /**
     * 自定义第三方bean
     * 这里是把dbcp datasource 引进spring中
     *
     * 条件装配
     * 某些情况下不希望Ioc去进行bean的自动装配
     * 见package com.zhutao.ioc.condition
     * 条件装配如果错过自动装配,如何处理?
     *
     * bean的作用域
     */
    @Bean(value = "dataSource")
    @Conditional({DatabaseCondition.class})
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
