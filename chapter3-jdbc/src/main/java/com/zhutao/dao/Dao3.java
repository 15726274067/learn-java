package com.zhutao.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zhutao.config.AppConfig;
import jdk.nashorn.internal.runtime.Property;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据库连接池
 *
 * 池化技术,适用于资源创建,释放消耗大的情况
 * connection::close() 不会再释放链接,而是将连接归还给连接池
 *
 * @Author: zhutao
 * @Date: 2019/2/12 9:12
 * @Version 1.0
 */
@Component
public class Dao3 {

    @Autowired
    private AppConfig config = null;

    @Bean("dataSource")
    public DataSource getDataSource(){
        DataSource dataSource = null;
        Properties prop = new Properties();
        prop.setProperty("driver", config.getDriverName());
        prop.setProperty("url", config.getUrl());
        prop.setProperty("username", config.getUsername());
        prop.setProperty("password", config.getPassword());
        try {
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 数据量连接池 druid
     * @return
     * @throws Exception
     */
    @Bean("druid")
    public DataSource getDruidDataSource() throws Exception {
        Properties prop = new Properties();
        InputStream inputStream = Dao3.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(inputStream);

        return DruidDataSourceFactory.createDataSource(prop);
    }
}
