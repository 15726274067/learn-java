package com.zhutao.gof.behavior.chain;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 19:58
 * @Version 1.0
 */
public abstract class Handler {

    protected Handler successor;


    public Handler(Handler successor) {
        this.successor = successor;
    }


    protected abstract void handleRequest(Request request);


    public static void main(String[] args) {
        HandlerA handlerA = new HandlerA(null);

        HandlerB handlerB = new HandlerB(handlerA);

        Request request = new Request(RequestType.TYPEA, "requestA");
        handlerB.handleRequest(request);

        Request request2 = new Request(RequestType.TYPEB, "requestB");
        handlerB.handleRequest(request);
    }
}
