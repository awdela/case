package com.test.designPattern.factory;

public class HumanFactory extends AbstractHumanFactory{

	@Override
	public <T extends Human> T creatHuman(Class<T> t) {
		Human human = null;
		try {
			human = (Human)Class.forName(t.getName()).newInstance();
		}catch(Exception e) {
			System.out.println("creat human failed");
		}
		return (T)human;
	}

}
