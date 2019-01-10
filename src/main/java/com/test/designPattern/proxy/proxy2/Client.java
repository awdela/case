package com.test.designPattern.proxy.proxy2;

import java.lang.reflect.InvocationHandler;

public class Client {

    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject realSubject = new SubjectImp();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

//        Subject subject =

    }

}
