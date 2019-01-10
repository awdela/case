package com.test.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    // 待理解
    public int[] sort(int[] arr) {
        int[] nums = Arrays.copyOf(arr, arr.length);
        if (nums.length < 2) {
            return nums;
        }
        int middle = (int) Math.floor(nums.length >> 1);
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = new Random().nextInt(100);
        }
        int[] num = new MergeSort().sort(nums);
        for (int i : num) {
            System.out.println(i + " ");
        }
    }

}
