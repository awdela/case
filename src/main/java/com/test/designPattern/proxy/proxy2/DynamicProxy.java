package com.test.designPattern.proxy.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
 * 动态代理
 */

public class DynamicProxy implements InvocationHandler{

    private Object subject;

    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在代理真实的对象前可以添加一些自己的操作
        System.out.println("before proxy");
        System.out.println("Method:"+method);
        // 当代理对象调用真实对象的方法时，会自动跳转到代理对象关联的handler对象的invoker方法来进行调用
        method.invoke(subject, args);
        // 在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after proxy");
        return null;
    }

}
