package com.test.container;

import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {
        SortedMap map = new TreeMap<>();
        for(int i=0;i<10;i++) {
            int d = new Random().nextInt(100);
            map.put(d, "test");
            System.out.println(d+"\n");
        }
        System.out.println(map.firstKey());
        SortedMap map2 = map.tailMap(5);
        System.out.println("first key: ");
        System.out.println(map2.firstKey());
        System.out.println("last key: ");
        System.out.println(map2.lastKey());
    }

}
