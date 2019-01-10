package com.test.designPattern.state;

/**
 * 抽象环境
 */
public abstract class State {

    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void hand1();

    public abstract void hand2();

}
