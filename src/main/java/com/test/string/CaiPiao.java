package com.test.string;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CaiPiao {

    public static void main(String[] args) {
        int[] randomNum = new int[] {
                6, 22, 7, 9, 8, 27, 19,
                21, 2, 1, 10, 12, 32, 24,
                20, 30, 11, 14, 15, 26, 16,
                29, 28, 13, 27, 23, 20, 17};
        int[][] result = new int[10][7];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Set<Integer> set = new HashSet<>();
            while(set.size()<7) {
                int temp = random.nextInt(27);
                if (!set.contains(randomNum[temp])) {
                    result[i][set.size()] = randomNum[temp];
                    set.add(randomNum[temp]);
                }
            }
            set.clear();
        }
        for (int i = 0; i < result.length; i++) {
            int[] result0 = result[i];
            for (int j = 0; j < result0.length; j++) {
                System.out.print(result0[j]);
                System.out.print(" ");
            }
            System.out.println("\r\n");
        }
    }

}
