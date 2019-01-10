package com.test.designPattern.proxy;

public class GamePlayer implements IGamePlayer{

    private String name = "";

    public GamePlayer(String _name) {
        this.name = _name;
    }

    public void login() {
        System.out.println(this.name+" 登陆成功!");
    }
    public void killBoss() {
        System.out.println(this.name+" 在打怪!");
    }
    public void upgrade() {
        System.out.println(this.name+" 升了一级!");
    }
}
