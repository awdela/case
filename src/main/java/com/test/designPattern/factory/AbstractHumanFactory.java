package com.test.designPattern.factory;

/*
 * ����ģʽ
 */
public abstract class AbstractHumanFactory {
	
	public abstract <T extends Human> T creatHuman(Class<T> t);
	
}
