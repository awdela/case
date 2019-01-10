package com.test.time;

import java.io.Serializable;

public class ResultBean<T> implements Serializable{

    private static final long serialVersionUID = 1L;

    private static final int SUCCESS = 0;
    private static final int FAILED = 1;
    private String msg = "success";
    private int code = SUCCESS;
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable t) {
        super();
        this.msg = t.getMessage();
        this.code = FAILED;
    }

    @Override
    public String toString() {
        return "ResultBean [msg=" + msg + ", code=" + code + ", data=" + data + "]";
    }

}