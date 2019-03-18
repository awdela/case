package com.test.designPattern.factory;

public class NvWa {

	public static void main(String[] args) {
		AbstractHumanFactory birth = new HumanFactory();
		Human human = birth.creatHuman(YellowHuman.class);
		human.eat();
		human.color();
	}
}
