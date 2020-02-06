package com.zhutao.learn.core.javacore.gof.behavior.chain;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 20:02
 * @Version 1.0
 */
public class Request {

    private RequestType type;
    private String name;


    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }


    public RequestType getType() {
        return type;
    }


    public String getName() {
        return name;
    }
}
