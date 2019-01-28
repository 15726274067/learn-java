package com.zhutao.interface_;

import com.zhutao.javacore.interface_.BookService;
import com.zhutao.javacore.interface_.UserService;
import com.zhutao.javacore.interface_.impl.ServiceImpl;
import org.junit.Test;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 14:12
 * @Version 1.0
 */
public class test1 {
    @Test
    public void test1(){
        BookService bookService = new ServiceImpl();
        bookService.add("haa");

        UserService userService = new ServiceImpl();
        userService.add("haa");
    }
}
