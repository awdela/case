package com.test.designPattern.proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        // 我们要代理的真实对象
        Subject realSubject = new SubjectImp();

        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new DynamicProxy(realSubject);

        /**
         * 通过Proxy的newProxyInstance方法来创建我们的代理对象 并不是由SubjectImp生成的对象
         */
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(), realSubject.getClass().getInterfaces(), handler);

        System.out.println(subject.getClass().getName());

        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        subject.rent();

        subject.hello("world");

    }

}
