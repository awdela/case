package com.test.designPattern.observer2;

import java.util.List;

public class ConcreteSubject implements Subject{

    private List<Observer> objList;

    private int state;

    @Override
    public void attach(Observer o) {
        objList.add(o);
    }

    @Override
    public void detach(Observer o) {
        objList.remove(o);
    }

    @Override
    public void listener() {
        for(Observer o:objList) {
            o.update();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
