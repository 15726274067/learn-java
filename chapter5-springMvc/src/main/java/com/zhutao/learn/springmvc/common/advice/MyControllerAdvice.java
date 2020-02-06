package com.zhutao.learn.springmvc.common.advice;

import com.zhutao.learn.springmvc.common.exception.CustomException;
import com.zhutao.learn.springmvc.common.validator.UserValidator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 给控制器增加通知
 * • @ControllerAdvice(RestControllerAdvice): 定义一个控制器的通知类.允许定义一些关于增强控制器的各类通知和
 * 限定增强哪些控制器功能等
 *
 * • @InitBinder: 定义控制器参数绑定规则, 如转换规则,格式化等,它会在参数转换之前执行
 * • @ExceptionHandler：定义控制器发生异常后的操作,发生异常后,可以跳转到指
 * 定的友好页面/返回统一信息
 * • @ModelAttribute：可以在控制器方法执行之前，对数据模型进行操作
 * @Author: zhutao
 * @Date: 2019/2/21 14:50
 * @Version 1.0
 */
@ControllerAdvice(basePackages = "com.zhutao.learn.springmvc.controller",
        annotations = { RestController.class, Controller.class })
public class MyControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        // 绑定验证器
        binder.setValidator(new UserValidator());
        // 定义日期参数格式，参数不再需要注解@DateTimeFormat,boolean 参数表示是否允许为空
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    @ModelAttribute
    public void projectModel(Model model){
        model.addAttribute("project_name", "chapter5-spring");
    }

    @ExceptionHandler(value = { CustomException.class } )
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> customExceptionHandler(CustomException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("err_code", ex.getCode());
        map.put("err_msg", ex.getMessage());
        return map;
    }

    /**
     * 非自定义异常的全局异常解析器
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { Exception.class } )
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> exceptionHandler(Exception ex){
        ex.printStackTrace();
        Map<String, Object> map = new HashMap<>();
        map.put("err_code", 500L);
        map.put("err_msg", "internal server error");
        return map;
    }
}
