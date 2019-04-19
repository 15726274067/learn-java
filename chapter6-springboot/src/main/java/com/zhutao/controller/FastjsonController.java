package com.zhutao.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: zhutao
 * @Date: 2019/4/18 18:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/fastjson")
public class FastjsonController {

    public Map<String, Object> getJson(){
        JSONObject.toJSONString(this);
        return null;
    }
}
