package com.test.lock;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    static class FIFOMutex {
        private final AtomicBoolean locked = new AtomicBoolean(false);
        private final Queue<Thread> waiters = new ConcurrentLinkedQueue<Thread>();

        public void lock() {
            boolean wasInterrupted = false;
            Thread current = Thread.currentThread();
            waiters.add(current);

            // Block while not first in queue or cannot acquire lock
            while (waiters.peek() != current || !locked.compareAndSet(false, true)) {
                LockSupport.park(this);
                if (Thread.interrupted()) // ignore interrupts while waiting
                    wasInterrupted = true;
            }

            waiters.remove();
            if (wasInterrupted) // reassert interrupt status on exit
                current.interrupt();
                System.out.println(current.getName()+" is interrupt");
        }

        public void unlock() {
            locked.set(false);
            LockSupport.unpark(waiters.peek());
        }
    }

    public static void main(String[] args) {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                FIFOMutex fm = new FIFOMutex();
                fm.lock();
            }
        });
//        thread2.start();
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                FIFOMutex fm = new FIFOMutex();
//                fm.lock();
//            }
//        });
//        thread3.start();
    }

}
