package com.zhutao.gof.behavior.command;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 20:28
 * @Version 1.0
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
