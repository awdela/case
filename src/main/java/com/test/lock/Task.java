package com.test.lock;

public class Task {

    public Task(String id) {
        this.id = id;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean doSomething() {
        return true;
    }


}
