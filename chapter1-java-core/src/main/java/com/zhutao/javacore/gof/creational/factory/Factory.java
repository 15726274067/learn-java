package com.zhutao.javacore.gof.creational.factory;

/**
 * 工厂方法
 *
 * 定义创建对象的接口,子类负责创建工作,具体创建哪个对象有子类决定
 * 设计模式 不是为了消灭变化
 * 而是为了将变化赶出到局部,核心思想是六大原则
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

class MainForm {
    private Factory factory;

    MainForm(Factory factory) {
        this.factory = factory;
    }

    MainForm() {

    }

    public static void main(String[] args) {
        Factory factory = new ConcertFactoryA();
        MainForm mainForm = new MainForm(factory);
        mainForm.ButtonClick();
    }

    void ButtonClick() {
        factory.doSomething();
    }
}