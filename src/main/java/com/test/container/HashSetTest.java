package com.test.container;

import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String args[]) {
//        Set<String> hs = new HashSet<String>();
//        hs.add("333");
//        hs.add("111");
//        hs.add("222");
//        Set<String> s = new HashSet<String>(hs);
//        System.out.println("s:" + s.toString());
//        TreeSet<Integer> ts = new TreeSet<Integer>();
//        ts.add(333);
//        ts.add(111);
//        ts.add(222);
//        System.out.println("ts:" + ts.toString());


        Set<String> list = new LinkedHashSet<>();
        list.add("333");
        list.add("111");
        list.add("111");
        list.add("222");
        list.add("999");
        list.add("444");
//        HashSet<String> hash = new HashSet<String>(list);
//        list.clear();
//        list.addAll(hash);
        System.out.println("list:" + list.toString());
    }

}
