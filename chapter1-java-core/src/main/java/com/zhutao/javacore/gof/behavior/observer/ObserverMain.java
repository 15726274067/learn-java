package com.zhutao.javacore.gof.behavior.observer;

/**
 * 观察者模式
 *
 * 定义对象之间的一对多依赖，当一个对象状态改变时，它的所有依赖都会收到通知并且自动更新状态
 * 主题（Subject）是被观察的对象，而其所有依赖者（Observer）称为观察者
 * 主题（Subject）具有注册和移除观察者、并通知所有观察者的功能，主题是通过维护一张观察者列表来实现这些操作的。
 * 观察者（Observer）的注册功能需要调用主题的 registerObserver() 方法。
 *
 * 目标发送通知时,无需指定观察者,通知会自动传播
 * 观察者自己决定是否要订阅通知. 目标对象对此一无所知(松耦合)
 * @Author: zhutao
 * @Date: 2019-06-28 20:03
 * @Version 1.0
 */
public class ObserverMain {
    public static void main(String[] args) {
        Subject subject = new SubjectA();

        Observer observer = new ObserverA(subject);
        Observer observerb = new ObserverB(subject);

        subject.notifyObserver();



    }
}
