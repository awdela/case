package com.test.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Listener2 implements Observed{

    private List<Observer> os = new ArrayList<Observer>();

    public void add(Observer o) {
        os.add(o);
    }

    public void notified(Message msg) {

        /**
         * 如果监听者比较多，可能会影响性能
         */
        for (Observer o : os) {
            o.update(msg);
        }
    }

}
