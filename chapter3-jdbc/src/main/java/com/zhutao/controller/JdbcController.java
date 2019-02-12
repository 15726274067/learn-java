package com.zhutao.controller;

import com.zhutao.config.AppConfig;
import com.zhutao.service.JdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: zhutao
 * @Date: 2019/2/11 21:01
 * @Version 1.0
 */
@Controller
@RestController
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private JdbcService jdbcService = null;

    @Autowired
    private AppConfig appConfig = null;

    @RequestMapping("/config")
    public HashMap<String, String> getConfig(){
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("driver", appConfig.getDriverName());
        hashMap.put("url", appConfig.getUrl());
        hashMap.put("password", appConfig.getPassword());
        hashMap.put("username", appConfig.getUsername());
        return hashMap;
    }
}
