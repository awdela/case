package com.test.designPattern.observer;

public class Message {

    private String id;
    private String msg;
    private InnerMessage inner;

    public Message(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void doIt() {
        if (inner == null) {
            inner = new InnerMessage();
        }
        inner.justDoIt("");
    }


}
