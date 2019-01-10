package com.test.designPattern.observer;

public interface Observed {

    public void add(Observer o);

    public void notified(Message msg);

}
