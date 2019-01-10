package com.test.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Subscribe implements Observer{


    public void update(Observable o, Object arg) {
        doSomething((String)arg);
    }

    public void doSomething(String msg) {
        System.out.println(msg);
    }

}
