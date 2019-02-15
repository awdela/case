package com.test.concurrent.conpractice;

public final class Counter {

    private long value = 10;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment(){
        return ++value;
    }


}
