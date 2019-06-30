package com.zhutao.gof.creational.factory;

/**
 * 工厂方法
 *
 * 定义创建对象的接口,子类负责创建工作,具体创建哪个对象有子类决定
 * @Author: zhutao
 * @Date: 2019-06-24 20:47
 * @Version 1.0
 */
public abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething() {
        Product product = factoryMethod();
        System.out.println(product.showName());
    }
}

class ConcertFactoryA extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcertProductA();
    }

    public static class ConcertProductA implements Product{

        @Override
        public String showName() {
            return "ConcertProductA";
        }
    }
}


class ConcertFactoryB extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcertProductB();
    }

    public static class ConcertProductB implements Product{

        @Override
        public String showName() {
            return "ConcertProductB";
        }
    }
}


class ConcertFactoryC extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcertProductC();
    }

    public static class ConcertProductC implements Product{

        @Override
        public String showName() {
            return "ConcertProductC";
        }
    }
}

class MainTest {
    private Factory factory;
    public static void main(String[] args) {

    }
}