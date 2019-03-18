package com.test.Excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class Task implements Runnable{

	private int taskId;

	public Task(int taskid) {
		this.taskId = taskid;
	}
	@Override
    public void run() {
		System.out.println(Thread.currentThread()+"---taskId---"+taskId);
	}

}

class DefaultThreadFactory implements ThreadFactory{

	@Override
    public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		try {
			thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.setDaemon(true);
		return thread;
	}

}

public class ThreadFactoryTest{

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(3, new DefaultThreadFactory());
		for(int i=0; i<5; i++) {
			exec.submit(new Task(i));

		}
		exec.shutdown();
	}

}
