package com.test.designPattern.observer2;

public interface Subject {

    public void attach(Observer o);

    public void detach(Observer o);

    public void listener();

    public int getState();

}
