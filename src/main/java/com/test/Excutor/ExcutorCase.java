package com.test.Excutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExcutorCase {

	private static final int threadSize = 10;

	private static Executor excutor = Executors.newFixedThreadPool(threadSize);

	static class Task implements Runnable {

		public void run() {
			for( int i=0;i<10;i++) {
				System.out.println(Integer.toString(i)+Thread.currentThread().getName());
			}
		}

	}

	public static void main(String[] args) {
	    SerialExecutor se = new SerialExecutor(excutor);
	    se.execute(new Task());
//		excutor.execute(new Task());
	}

}
