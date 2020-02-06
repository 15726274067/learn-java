package com.zhutao.learn.core.javacore.gof.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019-06-28 19:59
 * @Version 1.0
 */
public class SubjectA implements Subject {
    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(x -> {
            x.update(1);
        });
    }
}
