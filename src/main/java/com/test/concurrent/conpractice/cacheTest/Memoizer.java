package com.test.concurrent.conpractice.cacheTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Memoizer<A, V> implements Computable<A, V> {

    private final Computable<A, V> c;

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V computer(final A a) {
        while (true) {
            Future<V> f = cache.get(a);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {

                    @Override
                    public V call() throws Exception {
                        return c.computer(a);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                // 原子操作
                f = cache.putIfAbsent(a, ft);
                if (f == null) {
                    f = ft;
                    // 在这里调用c.computer
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (InterruptedException e) {
                cache.remove(a);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }
    }

}
