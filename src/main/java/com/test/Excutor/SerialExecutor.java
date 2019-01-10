package com.test.Excutor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

public class SerialExecutor implements Executor{

    final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
    final Executor executor;
    Runnable active;

    public SerialExecutor(Executor exec) {
        this.executor = exec;
    }

    public synchronized void execute(final Runnable command) {
//        tasks.offer(new Runnable() {
//            public void run() {
//                try {
//                    command.run();
//                }finally {
//                    goNextStep();
//                }
//            }
//        });
        tasks.offer(command);
        if (active == null) {
            goNextStep();
        }
    }

    private synchronized void goNextStep() {
        if ((active = tasks.poll()) != null){
            executor.execute(active);
        }
    }



}
