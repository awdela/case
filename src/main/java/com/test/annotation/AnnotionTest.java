package com.test.annotation;

import java.lang.reflect.Field;

public class AnnotionTest {

    public static void main(String[] args) {
        try {
            Class test = Class.forName("com.test.annotation.Annotion2");
            for (Field field : test.getDeclaredFields()) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("not found");
        }
    }

}
