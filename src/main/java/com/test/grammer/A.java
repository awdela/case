package com.test.grammer;

public class A {

    /**
     * Class A 类似于BOReposiyory
     */

    private CallBack callBack;

    public void register(CallBack callBack) {
        this.callBack = callBack;
    }

    public void call() {
        callBack.call();
    }

    public static void main(String[] args) {
        A a = new A();
        a.register(new CallBack() {

            @Override
            public void call() {
                System.out.println("回调函数被调用");
            }
        });
        a.call();
    }

}
