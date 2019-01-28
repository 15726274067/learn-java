package com.zhutao.lambda.functions;

/**
 * @Author: zhutao
 * @Date: 2019/1/28 16:28
 * @Version 1.0
 */
@FunctionalInterface
/**
 * 函数式编程自定义接口
 */
public interface MyFunction<T, U> {
    T run(T t, U u);
}
