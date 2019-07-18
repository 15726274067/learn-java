package com.zhutao.javacore.gof.structural.flyweight;

/**
 * 享元模式
 * 利用共享的方式来支持大量细粒度的对象，这些对象一部分内部状态是相同的。
 * - Flyweight：享元对象
 * - IntrinsicState：内部状态，享元对象共享内部状态
 * - ExtrinsicState：外部状态，每个享元对象的外部状态不同
 *
 * 享元模式下的对象最好是只读的(String)
 * @Author: zhutao
 * @Date: 2019-06-30 17:21
 * @Version 1.0
 */
public interface Flyweight {
    void doOperation(String extrinsicState);
}
