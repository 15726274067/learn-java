package com.zhutao.learn.spring.ioc.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 加载配置文件
 * 2. ConfigurationProperties注解
 * 注解＠ConfigurationProperties 中配置的字符串 database，将与 POJO 的属性名称组成属性
 * 的全限定名去配置文件里查找 ，这样就能将对应的属性读入到 POJO 当中
 * 需要使用PropertySource来指定path
 *
 * @Author: zhutao
 * @Date: 2019/2/1 23:26
 * @Version 1.0
 */
@Component
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true)
@ConfigurationProperties("database")
public class DataBaseProperties2 {
    private String driverName;

    private String url;

    private String username;

    private String password;

    public String getDriver() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "{ driver='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
