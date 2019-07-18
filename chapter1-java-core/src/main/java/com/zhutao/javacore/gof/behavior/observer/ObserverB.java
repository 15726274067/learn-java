package com.zhutao.javacore.gof.behavior.observer;

/**
 * @Author: zhutao
 * @Date: 2019-06-28 20:01
 * @Version 1.0
 */
public class ObserverB implements Observer {
    public ObserverB(Subject subject) {
        subject.registerObserver(this);
    }

    public ObserverB() {
    }

    @Override
    public void update(int value) {
        System.out.println("this is ObserverB, value: " + value);
    }
}
