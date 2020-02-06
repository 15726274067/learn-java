package com.zhutao.learn.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication(scanBasePackages = "com.zhutao.learn.mybatis")
/**
 * 自动将扫描到的包注入到spring中
 */
@MapperScan(
        // springboot 扫描包路径
        basePackages = "com.zhutao.learn.mybatis",
        // 指定 sqlSessionFactory，如果 sqlSessionTemplate被指定,则作废
        // 项目中不存在多个sqlSessionFactory时,可以不配置
        // sqlSessionFactoryRef = "sqlSessionFactory",

        // 指定 sqlSessionTemplate，如果 sqlSessionFactory被指定,则作废
        // 项目中不存在多个sqlSessionFactory时,可以不配置
        // sqlSessionTemplate的优先权是大于 sqlSessionFactory 的
        // sqlSessionTemplateRef = "sqlSessionTemplate",

        // 限定扫描接口,一般不用
        // markerInterface = Class.class,

        // 限定注解,只有带@Repository注解的包才会被扫描
        annotationClass = Repository.class
)
public class MyBatisApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(MyBatisApplication.class);
    }
}
