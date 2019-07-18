package com.zhutao.javacore.gof.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 20:31
 * @Version 1.0
 */
public class Invoker {
    private List<Command> commandOnList;

    private List<Command> commandOffList;

    public static final int SLOT_NUM = 16;

    public Invoker() {
        this.commandOnList = new ArrayList<>(SLOT_NUM);
        this.commandOffList = new ArrayList<>(SLOT_NUM);
    }

    public void setCommandOnList(int index, Command command) {
        if (index < SLOT_NUM) {
            this.commandOnList.add(index, command);
        }
    }

    public void setCommandOffList(int index, Command command) {
        if (index < SLOT_NUM) {
            this.commandOffList.add(index, command);
        }
    }

    public void onButton(int index){
        Command command = commandOnList.get(index);
        if (command != null) command.execute();
    }


    public void offButton(int index){
        Command command = commandOffList.get(index);
        if (command != null) command.execute();
    }


    public static void main(String[] args){
        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        Invoker invoker = new Invoker();
        invoker.setCommandOffList(0, lightOffCommand);
        invoker.setCommandOnList(0, lightOnCommand);
        invoker.onButton(0);
        invoker.offButton(0);
    }
}
