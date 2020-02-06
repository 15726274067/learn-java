package com.zhutao.learn.core.javacore.gof.behavior.chain;

/**
 * 责任链模式
 *
 * 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链发送该请求，直到有一个对象处理它为止。
 *
 * Handler：定义处理请求的接口，并且实现后继链（successor）
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
