package com.test.concurrent.conpractice;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

/**
 * 设置有边界的Set
 */
public class BoundHashSet<T> {

    private final HashSet<T> set;

    private final Semaphore sem;

    public BoundHashSet(int bound) {
        this.set = (HashSet<T>) Collections.synchronizedSet(new HashSet<T>());
        sem = new Semaphore(bound);
    }

    public boolean add(T t) throws InterruptedException {
        // 消耗一个许可,如果超过许可的量则堵塞以此来控制set的边界
        sem.acquire();
        boolean wasAdd = false;
        try {
            wasAdd = set.add(t);
            return wasAdd;
        } finally {
            if (!wasAdd) {
                // 如果没有添加成功则恢复一个许可
                sem.release();
            }
        }
    }

    public boolean remov(T t) {
        boolean wasRemoved = false;
        wasRemoved = set.remove(t);
        if (!wasRemoved) {
            sem.release();
        }
        return wasRemoved;
    }

}
