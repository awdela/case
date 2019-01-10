package com.test.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    static Object data;
    static volatile boolean cacheValid;
    static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        rwl.readLock().lock();
        if (!cacheValid) {
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            try {
                if (cacheValid) {
                    data = "";
                    cacheValid = true;
                }
                rwl.readLock().lock();
            }finally {
                rwl.writeLock().unlock();
            }
        }
        try {
            use(data);
        }finally {
            rwl.readLock().unlock();
        }

    }

    private static void use(Object data2) {

    }

}
