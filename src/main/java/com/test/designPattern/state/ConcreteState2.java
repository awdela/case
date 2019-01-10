package com.test.designPattern.state;

/**
 * 具体环境2
 */
public class ConcreteState2 extends State{

    @Override
    public void hand1() {
      //设置当前状态为state1
        super.context.setState(context.STATE1);
        //过渡到state2状态，有context实现
        super.context.handle1();
    }

    @Override
    public void hand2() {
      //当前状态必须要做的事
        System.out.println("自定义行为handle2");
    }

}
