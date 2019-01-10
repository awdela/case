package com.test.designPattern.state;

public class Context {

    //定义状态
    public final static State STATE1 = new ConcreteState1();

    public final static State STATE2 = new ConcreteState2();

    //当前状态
    private State currentState;

    public void setState(State state) {
        //设置当前状态
        this.currentState = state;
        //切换状态
        this.currentState.setContext(this);
    }

    public State getStat() {
        return currentState;
    }

    //行为委托
    public void handle1() {
        this.currentState.hand1();
    }

    public void handle2() {
        this.currentState.hand2();
    }

}
