package com.zhutao.gof.behavior.command;

/**
 * 设计一个遥控器，可以控制电灯开关
 * @Author: zhutao
 * @Date: 2019-06-25 20:29
 * @Version 1.0
 */
public class Light {
    public void on() {
        System.out.println("light on");
    }

    public void off() {
        System.out.println("light off");
    }
}
