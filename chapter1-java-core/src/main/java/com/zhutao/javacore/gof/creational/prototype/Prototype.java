package com.zhutao.javacore.gof.creational.prototype;

/**
 * 原型模式
 *
 * 使用原型实例指定要创建对象的类型，通过复制(克隆)这个原型来创建新对象
 * js的原型继承
 * @Author: zhutao
 * @Date: 2019-06-25 19:46
 * @Version 1.0
 */
public abstract class Prototype {
    abstract Prototype getClone();
}
