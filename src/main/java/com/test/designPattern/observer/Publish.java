package com.test.designPattern.observer;

import java.util.Observable;

public class Publish extends Observable{

    @Override
    public void notifyObservers() {
        super.setChanged();
        super.notifyObservers("shabi");
    }


}
