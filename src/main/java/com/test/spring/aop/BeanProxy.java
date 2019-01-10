package com.test.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.test.spring.aop.aspect.MyAspect;
import com.test.spring.aop.bean.UserDao;

/*
 * 代理类
 */
public class BeanProxy implements InvocationHandler {

    // 声明目标类接口
    private UserDao user;

    // 创建代理方法
    @SuppressWarnings("rawtypes")
    public Object creatProxy(UserDao userDao) {
        this.user = userDao;
        // 1 类加载器
        ClassLoader classLoader = BeanProxy.class.getClassLoader();
        // 2 被代理对象实现的所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        // 3 使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader, clazz, this);
    }

    /**
     * 所有动态代理类的方法调用，都会交由invoke()方法去处理 proxy 被代理后的对象 method 将要执行的方法 args 执行方法时需要的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 声明切面
        MyAspect myAspect = new MyAspect();

        // 指定位置程序执行前执行这个方法
        myAspect.start();

        // 在目标类上调用方法
        Object obj = method.invoke(user, args);

        // 指定位置程序结束后执行
        myAspect.end();

        return obj;
    }

}
