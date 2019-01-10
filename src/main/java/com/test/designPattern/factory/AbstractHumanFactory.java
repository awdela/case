package com.test.designPattern.factory;

/*
 * 工厂模式
 */
public abstract class AbstractHumanFactory {
	
	public abstract <T extends Human> T creatHuman(Class<T> t);
	
}
