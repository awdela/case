package com.test.Excutor;

public interface DataProcessor<D, R> {

    public R process(D data);

}