package com.test.designPattern.proxy;

public class Client {

    public static void main(String[] args) {
        GamePlayerProxy player = new GamePlayerProxy(new GamePlayer("uzi"));
        System.out.println("開始時間"+System.currentTimeMillis());
        player.login();
        player.killBoss();
        player.upgrade();
        System.out.println("結束時間"+System.currentTimeMillis());
    }
}
