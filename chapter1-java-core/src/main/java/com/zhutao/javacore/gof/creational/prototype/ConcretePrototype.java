package com.zhutao.javacore.gof.creational.prototype;

/**
 * @Author: zhutao
 * @Date: 2019-06-25 19:53
 * @Version 1.0
 */
public class ConcretePrototype extends Prototype {
    private String field;

    public ConcretePrototype(String field) {
        this.field = field;
    }

    /**
     * 复制这个原型来创建对象
     * @return
     */
    @Override
    Prototype getClone() {
        return new ConcretePrototype(field);
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "field='" + field + '\'' +
                '}';
    }

    public static void main(String[] args){
        Prototype concretePrototypeA = new ConcretePrototype("a");

        Prototype concretePrototypeB = concretePrototypeA.getClone();

        System.out.println(concretePrototypeA.toString());

        System.out.println(concretePrototypeB.toString());
    }
}
