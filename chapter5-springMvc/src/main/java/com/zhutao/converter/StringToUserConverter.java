package com.zhutao.converter;

import com.zhutao.enumation.SexEnum;
import com.zhutao.pojo.User;
import org.springframework.core.convert.converter.*;
import org.springframework.stereotype.Component;

/**
 * Converter 是一对一的转化器. 也就是从一种类型转换为另外一种类型
 * SpringMVC 就会通过 HTTP的参数类型(String) 和控制器的参数类型(User)进行匹配,
 * 从注册机制中发现这个转换类,将参数转换出来
 * @Author: zhutao
 * @Date: 2019/2/20 22:37
 * @Version 1.0
 */
@Component
public class StringToUserConverter implements Converter<String, User> {
    @Override
    public User convert(String userStr) {
        String []strArr = userStr.split ("-");
        Long id = Long.parseLong(strArr[0]) ;
        String userName = strArr[1] ;
        String note= strArr[2] ;
        SexEnum sex = SexEnum.valueOf(strArr[3]);
        return new User(id, userName, note, sex) ;
    }
}
