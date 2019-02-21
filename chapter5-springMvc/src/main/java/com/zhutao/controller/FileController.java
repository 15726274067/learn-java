package com.zhutao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 对于文件的上传可以使用 Servlet API 提供的 Part 接口或者 Spring MVC 提供的MultipartFile 接口作为参数
 * 更加推荐使用Part, 因为毕竟MultipartFile 是 SpringMVC 提供的第三方包才能进行支持的
 * @Author: zhutao
 * @Date: 2019/2/21 8:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload/request")
    @ResponseBody
    public Map<String, Object> upload(HttpServletRequest request){
        boolean flag = false;
        MultipartHttpServletRequest servletRequest = null;
        if (request instanceof MultipartHttpServletRequest){
            servletRequest = (MultipartHttpServletRequest) request;
        } else {
            return dealRestMap(false, "文件上传失败");
        }

        // 获取MultipartFile文件信息
        MultipartFile multipartFile = servletRequest.getFile("file");
        String fileName = multipartFile.getName();
        File file = new File(fileName);

        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return dealRestMap(false, "文件上传失败");
        }
        return dealRestMap(true, "文件上传成功");
    }

    @ResponseBody
    @PostMapping("/upload/part")
    public Map<String, Object> uploadPart(Part file){
        // 推荐使用
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return dealRestMap(false, "文件上传失败");
        }
        return dealRestMap(true, "文件上传成功");
    }

    private Map<String, Object> dealRestMap(boolean success, String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("success", success);
        map.put("message", message);
        return map;
    }

}
