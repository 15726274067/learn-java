package com.zhutao.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个拦截器 责任链模式
 *
 * Interceptor1invoke preHandle...
 * Interceptor2invoke preHandle...
 * Interceptor3invoke preHandle...
 * 执行处理器逻辑
 * Interceptor3invoke postHandle...
 * Interceptor2invoke postHandle...
 * Interceptor1invoke postHandle...
 * Interceptor3invoke afterCompletion...
 * Interceptor2invoke afterCompletion...
 * Interceptor1invoke afterCompletion...
 *
 * 一旦preHandle返回 false ，则后续的拦截器,处理器和 postHandle方法都不会被执行
 * 完成方法 afterCompletion则不一样，只执行返回 true 的拦截器的完成方法,而且顺序是先注册后执行
 *
 * @Author: zhutao
 * @Date: 2019/2/21 14:19
 * @Version 1.0
 */
public class Interceptor3 implements HandlerInterceptor {
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
