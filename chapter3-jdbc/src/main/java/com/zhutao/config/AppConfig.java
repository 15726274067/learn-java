package com.zhutao.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 20:50
 * @Version 1.0
 */
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(value = "myconfig.database")
public class AppConfig {
    private String driverName;

    private String url;

    private String username;

    private String password;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
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
}
