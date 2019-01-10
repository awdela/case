package com.test.container;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String args[]) {
        Set<String> hs = new HashSet<String>();
        hs.add("333");
        hs.add("111");
        hs.add("222");
        Set<String> s = new HashSet<String>(hs);
        System.out.println("s:" + s.toString());
//        TreeSet<Integer> ts = new TreeSet<Integer>();
//        ts.add(333);
//        ts.add(111);
//        ts.add(222);
//        System.out.println("ts:" + ts.toString());
//
//        List<String> list = new ArrayList<>();
//        list.add("333");
//        list.add("111");
//        list.add("111");
//        list.add("222");
//        HashSet<String> hash = new HashSet<String>(list);
//        list.clear();
//        list.addAll(hash);
//        System.out.println("list:" + list.toString());
    }

}
