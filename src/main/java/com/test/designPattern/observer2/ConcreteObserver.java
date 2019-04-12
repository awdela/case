package com.test.designPattern.observer2;

public class ConcreteObserver implements Observer{

    @Override
    public void update() {
        System.out.println("listener is listened");
    }

}
