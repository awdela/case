package com.test.concurrent.conpractice.cacheTest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

public class Memoizer<A, V> implements Computable<A, V>{

    private final Computable<A, V> c;

    private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V computer(A a) {
        cache.
        if () {

        }
        return null;
    }

}
