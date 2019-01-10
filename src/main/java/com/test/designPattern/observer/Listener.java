package com.test.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Listener implements Observed{

    private List<Observer> os = new ArrayList<Observer>();

    public void add(Observer o) {
        os.add(o);
    }

    public void notified(Message msg) {
        for (Observer o : os) {
            o.update(msg);
        }
    }

}
