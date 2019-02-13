package com.test.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	
	static class Worker implements Runnable{
		private final CountDownLatch latch;
		private final String str;
		private final int i;
		Worker(int i, CountDownLatch latch, String str){
			this.i = i;
			this.latch = latch;
			this.str = str;
		}
		
		public void run() {
			doWork();
			latch.countDown();
		}

		private synchronized void doWork() {
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName+String.valueOf(i)+": "+str+'\n');
		}
		
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("just");
		list.add("a");
		list.add("test");
		list.add("do");
		list.add("it");
		CountDownLatch latch = new CountDownLatch(list.size());
		for (int i=0;i<list.size();i++) {
			new Thread(new Worker(i,latch, list.get(i))).start();
		}
		try {
			latch.await();
			System.out.println("done");
		} catch (InterruptedException e) {
		}
		
	}

}
