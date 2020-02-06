package com.zhutao.learn.springboot.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Swagger2 注解简介
 * @Author: zhutao
 * @Date: 2019/3/19 15:04
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api
public class UserController {

    @GetMapping("")
    @ApiOperation(value = "用户列表", notes = "获取用户列表接口")
    public Map<String, Object> userList(){
        return null;
    }

    @PostMapping("")
    @ApiOperation(value = "创建用户", notes = "创建用户 post")
    @ApiParam(name = "name", value = "string", defaultValue = "hhh", required = true)
    public Map<String, Object> saveUser(@RequestBody String name){
        return null;
    }
}
