package com.test.Therad;

public class ThreadLocalTest {

    // ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    // ThreadLocal<String> stringLocal = new ThreadLocal<String>();
    Long longLocal;
    String stringLocal;

    public void set() {
        longLocal = Thread.currentThread().getId();
        stringLocal = Thread.currentThread().getName();
    }

    public long getLong() {
        return longLocal;
    }

    public String getString() {
        return stringLocal;
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalTest test = new ThreadLocalTest();

        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
    // private static String value;
    //
    // private static ThreadLocal<String> thread = new ThreadLocal<String>() {
    //
    // @Override
    // protected String initialValue() {
    // value = "inited";
    // return value;
    // }
    // };
    //
    // public static void main(String[] args) {
    // System.out.println(thread.get());
    // }
}
