package com.test.designPattern.proxy;

public class GamePlayerProxy implements IGamePlayer{

    private IGamePlayer player = null;

    public GamePlayerProxy(IGamePlayer _gamePlayer) {
        this.player = _gamePlayer;
    }

    public void killBoss() {
        player.killBoss();
    }
    public void login() {
        player.login();
    }
    public void upgrade() {
        player.upgrade();
    }
}
