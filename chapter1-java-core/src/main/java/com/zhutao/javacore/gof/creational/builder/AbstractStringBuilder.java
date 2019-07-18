package com.zhutao.javacore.gof.creational.builder;

import java.util.Arrays;

/**
 * 创建者 builder 模式
 *
 * 封装一个对象的构造过程，并允许按步骤构造
 * 复杂对象的创建工作,由于需求变化,各个子部分变化剧烈,但将他们组合的方法比较稳定
 * 将构建过程和表示分离,以支持不同的表示
 * 参考 StringBuffer
 * https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html
 * @Author: zhutao
 * @Date: 2019-06-25 17:30
 * @Version 1.0
 */
public class AbstractStringBuilder {
    protected char[] value;

    protected int count;

    public AbstractStringBuilder(int count) {
        value = new char[count];
        this.count = count;
    }

    public AbstractStringBuilder append(char c) {
        ensureCapacity(count + 1);
        value[count++] = c;
        return this;
    }

    private void ensureCapacity(int count) {
        if (value.length == count) {
            expendCapacity(count);
        }
    }

    private void expendCapacity(int minimumCapacity) {
        int newCapacity = value.length * 2 + 2;
        if (newCapacity - minimumCapacity < 0)
            newCapacity = minimumCapacity;
        if (newCapacity < 0) {
            if (minimumCapacity < 0) // overflow
                throw new OutOfMemoryError();
            newCapacity = Integer.MAX_VALUE;
        }
        value = Arrays.copyOf(value, newCapacity);
    }
}
