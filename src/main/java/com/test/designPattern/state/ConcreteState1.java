package com.test.designPattern.state;

/**
 * 具体环境1
 */
public class ConcreteState1 extends State{

    @Override
    public void hand1() {
        //当前状态必须要做的事
        System.out.println("自定义行为handle1");
    }

    @Override
    public void hand2() {
//        System.out.println("自定义行为handle12");
        //设置当前状态为state2,切换到ConcreteState2去执行
        super.context.setState(context.STATE2);
        //过渡到state2状态，有context实现
        super.context.handle2();
    }

}
