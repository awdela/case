package com.test.Excutor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskTest extends RecursiveTask{

    private static final long serialVersionUID = 1L;

    private final int n;

    public RecursiveTaskTest(int n) {
        this.n = n;
    }

    @Override
    protected Object compute() {
        if (n<=1) {
            return n;
        }else {
            /**
             * 先fork然后再join
             */
            RecursiveTaskTest rt1 = new RecursiveTaskTest(n-1);
            rt1.fork();
            RecursiveTaskTest rt2 = new RecursiveTaskTest(n-2);
            rt2.fork();
            return (Integer)rt1.compute()+(Integer)rt2.join();
        }
    }

    public static void main(String[] args) {
        //forkjoin任务线程池 跟Executor用法相同
        ForkJoinPool pool = new ForkJoinPool();
        int result = (int) pool.invoke(new RecursiveTaskTest(5));
        System.out.println(result);
    }

}
