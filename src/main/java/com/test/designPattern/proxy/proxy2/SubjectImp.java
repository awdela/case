package com.test.designPattern.proxy.proxy2;

public class SubjectImp implements Subject {

    @Override
    public void hello(String str) {
        System.out.println("hello:"+str);
    }

    @Override
    public void rent() {
        System.out.println("i want rent my big house");
    }

}
