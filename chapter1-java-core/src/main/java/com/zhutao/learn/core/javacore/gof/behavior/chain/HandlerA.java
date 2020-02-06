package com.zhutao.learn.core.javacore.gof.behavior.chain;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 20:09
 * @Version 1.0
 */
public class HandlerA extends Handler {
    public HandlerA(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPEA) {
            System.out.println("name: " + request.getName() + "handle by handlerA");
            return;
        }

        if (this.successor != null) {
            successor.handleRequest(request);
        }
    }
}
