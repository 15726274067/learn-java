package com.zhutao.javacore.gof.behavior.chain;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 20:09
 * @Version 1.0
 */
public class HandlerB extends Handler {
    public HandlerB(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPEA) {
            System.out.println("name: " + request.getName() + "handle by handlerB");
            return;
        }

        if (this.successor != null) {
            successor.handleRequest(request);
        }
    }
}
