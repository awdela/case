package com.test.distribute;

/**
 * 使用redis实现分布式锁
 */
public interface DistributeLock {

    public void lock();

    public void unlock();

    public void interrupt() throws Exception;

}
