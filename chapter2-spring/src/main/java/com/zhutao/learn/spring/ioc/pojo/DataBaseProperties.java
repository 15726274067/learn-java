package com.zhutao.learn.spring.ioc.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 加载配置文件
 * 1. 手动指定配置文件路径
 * 需要使用PropertySource来指定path
 *
 * @Author: zhutao
 * @Date: 2019/2/1 23:26
 * @Version 1.0
 */
@Component
@PropertySource(value = "classpath:application.properties")
public class DataBaseProperties {
    @Value("${database.driverName}")
    private String driver;

    @Value("${database.url}")
    private String url;

    private String username;

    private String password;

    public String getDriver() {
        return driver;
    }


    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    @Value("${database.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("${database.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataBaseProperties{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
