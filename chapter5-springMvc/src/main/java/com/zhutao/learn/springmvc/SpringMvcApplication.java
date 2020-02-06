package com.zhutao.learn.springmvc;

import com.zhutao.learn.springmvc.common.intercepter.Interceptor1;
import com.zhutao.learn.springmvc.common.intercepter.Interceptor2;
import com.zhutao.learn.springmvc.common.intercepter.Interceptor3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 需要进行注册才能够拦截处理器，为此需要在配置文件中实现 WebMvcConfigurer 接口
 * 最后覆盖其 addInterceptors 方法进行注册拦截器
 */
@SpringBootApplication(scanBasePackages = "com.zhutao.learn.springmvc")
public class SpringMvcApplication implements WebMvcConfigurer
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringMvcApplication.class);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器到springMvc中,返回一个拦截器注册
        InterceptorRegistration interceptorRegistration1 = registry.addInterceptor(new Interceptor1());

        // 指定拦截器匹配模式,限制拦截器请求
        interceptorRegistration1.addPathPatterns("/interceptor/*");

        InterceptorRegistration interceptorRegistration2 = registry.addInterceptor(new Interceptor2());
        interceptorRegistration2.addPathPatterns("/interceptor/*");

        InterceptorRegistration interceptorRegistration3 = registry.addInterceptor(new Interceptor3());
        interceptorRegistration3.addPathPatterns("/interceptor/*");
    }
}
