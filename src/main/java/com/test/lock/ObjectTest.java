package com.test.lock;

import java.util.Date;

/**
 * 测试Object类中的wait和notify方法
 * @author 15376
 *
 */
public class ObjectTest {

	private static Object lock = new Object();

	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						System.out.println(Thread.currentThread()+", get the lock"+new Date().getTime());
						lock.wait(10*1000);
						System.out.println(Thread.currentThread()+", get the lock"+new Date().getTime());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		}).start();;
		try {
			System.out.println("11111111");
			Thread.sleep(2*1000);
			System.out.println("22222222");
			synchronized (lock) {
				System.out.println(Thread.currentThread()+", get the lock"+new Date().getTime());
				lock.notify();
				System.out.println(Thread.currentThread()+", get the lock"+new Date().getTime());
				Thread.sleep(20*1000);
				System.out.println(Thread.currentThread()+"end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
