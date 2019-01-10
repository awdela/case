package com.test.lock;

import java.util.LinkedHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁完成一个多线程任务调度执行的过程
 */
public class TaskQueueExecutor {

    static class TaskInfo{
        Task task;
        Future<Task> future;
    }

    private static ExecutorService executor;

    private static LinkedHashMap<String, TaskInfo> data = new LinkedHashMap<String, TaskInfo>();

    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private static volatile long executorThreadId;

    public static Task getTask(String id) {
        // 获取读锁
        rwl.readLock().lock();
        try {
            TaskInfo taskInfo = data.get(id);
            if (taskInfo!=null) {
                return taskInfo.task;
            }else {
                return null;
            }
        }finally {
            rwl.readLock().unlock();
        }
    }

    private static Future<Task> asyncProcess(Task task) {
        Future<Task> future = new CompletableFuture<Task>();
        rwl.writeLock().lock();
        // 判断任务是否执行过,如果执行过直接退出,没有执行则继续执行
        try {
            if (data.containsKey(task.getId())) {
                return null;
            }
            TaskInfo taskInfo = new TaskInfo();
            taskInfo.task = task;
            taskInfo.future = future;
            data.put(task.getId(), taskInfo);
            if (executorThreadId==0) {
                executorThreadId = 1;
                executor.execute(()->{
                    execThreadFunc(task);
                    });
            }
            return future;
        }finally {
            rwl.writeLock().unlock();
        }
    }

    private static void execThreadFunc(Task task) {
        task.setId("2");
    }

    public static void main(String[] args) {

        Task task = new Task("1");
        Future<Task> future = asyncProcess(task);
        try {
            Task task2 = future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!future.isCancelled()) {
            System.out.println("exec done!");
        }else {
            System.out.println("exec error!");
        }
    }

}
