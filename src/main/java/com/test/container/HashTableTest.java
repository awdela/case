package com.test.container;

import java.util.Hashtable;

public class HashTableTest {

    public static void main(String[] args) {
        Hashtable<String, String> ht = new Hashtable<String, String>();
        ht.put("111", "111");
        ht.put("222", "222");
        ht.put("111", "333");
        System.out.println(ht.toString());
    }

}
