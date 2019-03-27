package com.test.algorithm.other;

import java.util.Random;

public class RandomCity {

    public static void main(String[] args) {
        String[] cities = new String[] {"xian","beijing","shanghai"};
        Random random = new Random();
        for (int i = 0; i < cities.length; i++) {
            System.out.println("visit: "+cities[random.nextInt(3)]+"\n");
        }
    }
}
