package com.test.algorithm.sort;

import java.util.Random;

/**
 * 冒泡排序
 * 思路：两层循环，如果前面的值大于后面的值就交换
 * 时间复杂度： O(n^2)
 * 优化思路：假如某一趟排序之后已经有序，我们需要减少排序的趟数
 * 补充：这种算法因为时间复杂度高而逐渐被舍弃
 */
public class BubbleSort implements Sort{

    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            boolean exchange = false;
            for (int j = i+1; j < len; j++) {
                if (nums[i]>nums[j]) {
                    int num = nums[i];
                    nums[i] = nums[j];
                    nums[j] = num;
                    exchange = true;
                }
            }
            if (!exchange) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for(int i =0;i<20;i++) {
            nums[i] = new Random().nextInt(100);
        }
        new BubbleSort().sort(nums);
        for (int i:nums) {
            System.out.println(i+" ");
        }
    }
}
