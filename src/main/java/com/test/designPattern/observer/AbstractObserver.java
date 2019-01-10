package com.test.designPattern.observer;

public abstract class AbstractObserver implements Observer{

    public void update(Message msg) {
//        System.out.println("监听者"+msg.getId()+"号"+msg.getMsg());
    }



}
