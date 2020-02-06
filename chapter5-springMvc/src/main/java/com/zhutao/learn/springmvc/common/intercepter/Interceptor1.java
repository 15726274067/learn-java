package com.zhutao.learn.springmvc.common.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 当请求来到 DispatcherServlet,它会根据 HandlerMapping 的机制找到处理器,
 * 返回一个包含处理器和拦截器的 HandlerExecutionChain 对象
 * 拦截器会对处理器进行拦截, 这样通过拦截器就可以增强处理器的功能
 *
 * 首先所有的拦截器都需要实现 HandIerInterceptor 接口
 *
 * 1. 执行 preHandle 方法,该方法会返回一个布尔值.如果为 false,则结束所有流程;如果为 true则执行下一步。
 * 2. 执行处理器逻辑,它包含控制器的功能
 * 3. 执行 postHandle 方法
 * 4. 执行视图解析和视图渲染
 * 5. 执行 afterCompletion 方法
 *
 * @Author: zhutao
 * @Date: 2019/2/21 14:19
 * @Version 1.0
 */
public class Interceptor1 implements HandlerInterceptor {
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
