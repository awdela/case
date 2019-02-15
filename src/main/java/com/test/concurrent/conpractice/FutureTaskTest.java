package com.test.concurrent.conpractice;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    class TaskInfo{
        private LocalDateTime startTime;
        private LocalDateTime endTime;
    }

    private final FutureTask<TaskInfo> future = new FutureTask<TaskInfo>(new Callable<TaskInfo>() {

        @Override
        public TaskInfo call() throws Exception {
            return getTaskInfo();
        }

    });

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public TaskInfo get() throws InterruptedException, ExecutionException {
        return future.get();
    }


    private TaskInfo getTaskInfo() {
        return null;
    }

}
