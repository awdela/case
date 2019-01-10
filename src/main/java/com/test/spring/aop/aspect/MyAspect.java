package com.test.spring.aop.aspect;

/**
 * 切面
 */
public class MyAspect {

    public void start() {
        System.out.println("模拟事务处理功能 ...");
    }

    public void end() {
        System.out.println("程序运行结束 ...");
    }
}
