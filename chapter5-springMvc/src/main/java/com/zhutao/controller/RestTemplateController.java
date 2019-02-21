package com.zhutao.controller;

import com.zhutao.pojo.User;
import com.zhutao.vo.UserVo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统间调用Rest请求
 *  RestTemplate 的底层是通过类 HttpURLConnection 实现的
 *
 *  PATCH 请求是为了完善PUT 请求后来加入的,在 JDK的HttpURLConnection 中并没有能够支持 PATCH 请求
 * @Author: zhutao
 * @Date: 2019/2/21 16:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/rest")
public class RestTemplateController {
    public static RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/get")
    public Map<String, Object> testGet(){
        /**
         * 1. url
         * 2. 返回类型
         * 3. 参数
         */
        String res = restTemplate.getForObject("https://www.baidu.com", String.class);
        System.out.println(res);
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);

        return map;
    }

    @GetMapping("/get-param")
    public Map<String, Object> testGetWithParam(){
        String url = "https://www.baidu.com";
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        params.put("id", 5L);
        String res = restTemplate.getForObject(url, String.class, params);
        System.out.println(res);
        map.put("success", true);
        return map;
    }

    @PostMapping("/post")
    public Map<String, Object> testPost(UserVo userVo){
        String url = "http://localhost:8080/user";
        // 请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        // 设置请求内容为json
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 创建请求实体对象
        HttpEntity<UserVo> request = new HttpEntity<>(userVo, httpHeaders);

        User user = restTemplate.postForObject(url, request, User.class);
        System.out.println(user.getId());
        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }

    @GetMapping("/delete")
    public Map<String, Object> testDelete(){
        Map<String, Object> map = new HashMap<>();
        String url = "https://www.baidu.com/{id}";

        restTemplate.delete(url, 1);
        map.put("success", true);
        return map;
    }
}
