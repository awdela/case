package com.test.container;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LinkedHashMapTest {

    private static final int MAX_RECENT_FAILED_IDS = 5;

    private static LinkedHashMap<String, String> errorInfo = new LinkedHashMap<String, String>() {

        @Override
        protected boolean removeEldestEntry(Entry<String, String> eldest) {
            if (size() > MAX_RECENT_FAILED_IDS) {
                return true;
            }
            return false;
        }

    };

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            errorInfo.put(String.valueOf(i), "ss");
            System.out.println(errorInfo.size());
        }
        errorInfo.put("ss", "s1");
        String flag = errorInfo.put("ss", "s1");
        System.out.println(flag);
    }

}
