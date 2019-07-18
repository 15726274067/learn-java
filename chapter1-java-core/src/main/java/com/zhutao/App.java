package com.zhutao;

/**
 * Hello world!
 *
 */
public class App {
    static {
        System.out.println(1);
        Thread thread = new Thread(() -> System.out.println("thread"));

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread");
//            }
//        });
        System.out.println(2);

        thread.start();
        System.out.println(3);

        try {
            System.out.println(4);

            thread.join();
            System.out.println(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }
}
