package com.zhutao.learn.springmvc.common.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhutao
 * @Date: 2019/2/21 14:19
 * @Version 1.0
 */
public class Interceptor2 implements HandlerInterceptor {
    /**
     * 处理器前置执行方法
     * @param request
     * @param response
     * @param handler
     * @return 是否拦截后续处理
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(this.getClass().getSimpleName() + "invoke preHandle...");
        System.out.println("getRequestURI: " + request.getRequestURI());
        return true;
    }

    /**
     * 处理器后置处理方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(this.getClass().getSimpleName() + "invoke postHandle...");
    }

    /**
     * 处理器完成后方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println(this.getClass().getSimpleName() + "invoke afterCompletion...");
    }
}
