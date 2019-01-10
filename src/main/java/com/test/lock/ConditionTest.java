package com.test.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

	private static int value = 1;
	private Lock lock =new ReentrantLock();
	private Condition condition456 = lock.newCondition();
	private Condition condition789 = lock.newCondition();
	private Condition condition112 = lock.newCondition();

	class Thread1 implements Runnable{

		public void run() {
			try {
				lock.lock();
				//先打印123
				System.out.println("print 123:");
				while (value<=3) {
					System.out.println(value);
					value++;
				}
				condition456.signal();
			   }
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			try {
				lock.lock();
				while( value<=6 ) {
					condition789.await();
				}
				lock.lock();
				System.out.println("print 789:");
				while (value<=9) {
					System.out.println(value);
					value++;
				}
				condition112.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			finally {
				lock.unlock();
			}

		}
	}

	class Thread2 implements Runnable{

		public void run() {
			try {
				lock.lock();
				while( value<4) {
					condition456.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			try {
				lock.lock();
				System.out.println("print 456:");
				while (value<=6) {
					System.out.println(value);
					value++;
				}
				condition789.signal();
			}catch(Exception e){
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			try {
				lock.lock();
				while( value<=9 ) {
					condition112.await();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
			try{
                lock.lock();
                System.out.println("输出10-12");
                while(value<=12)
                {
                    System.out.println(value++);
                }
            }
            finally
            {
                lock.unlock();
            }

		}
	}


	public static void main(String[] args) {

		ConditionTest test = new ConditionTest();
		Thread thread1 = new Thread(test.new Thread1());
		Thread thread2 = new Thread(test.new Thread2());
		thread1.start();
		thread2.start();

	}

}
