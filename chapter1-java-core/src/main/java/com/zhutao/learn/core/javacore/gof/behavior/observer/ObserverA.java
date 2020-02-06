package com.zhutao.learn.core.javacore.gof.behavior.observer;

/**
 * @Author: zhutao
 * @Date: 2019-06-28 19:57
 * @Version 1.0
 */
public class ObserverA implements Observer {

    public ObserverA() {
    }

    /**
     *观察者自己决定是否要订阅通知. 目标对象对此一无所知
     * @param subject
     */
    public ObserverA(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        System.out.println("this is ObserverA, value: " + value);
    }
}
