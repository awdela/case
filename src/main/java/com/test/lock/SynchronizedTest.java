package com.test.lock;

public class SynchronizedTest implements Runnable{

	static int i = 0;

	public void increment() {

		//synchronized(this) 此方法只对一个对象有效{
		synchronized(SynchronizedTest.class) {
			++i;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new SynchronizedTest());
		Thread thread2 = new Thread(new SynchronizedTest());

		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		System.out.println(i);
	}

	public void run() {
		for (int j = 0; j < 1000; j++) {
			increment();
		}
	}
}
