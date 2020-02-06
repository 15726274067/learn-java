package com.zhutao.learn.core.javacore.gof.behavior.command;

/**
 * 将命令封装成对象中，具有以下作用：
 *
 * 使用命令来参数化其它对象
 * 将命令放入队列中进行排队
 * 将命令的操作记录到日志中
 * 支持可撤销的操作
 * @Author: zhutao
 * @Date: 2019-06-25 20:28
 * @Version 1.0
 */
public interface Command {
    void execute();
}
