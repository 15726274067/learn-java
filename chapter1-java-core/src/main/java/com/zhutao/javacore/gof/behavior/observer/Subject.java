package com.zhutao.javacore.gof.behavior.observer;

/**
 * @Author: zhutao
 * @Date: 2019-06-28 19:44
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}
