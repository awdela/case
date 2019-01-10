package com.test.algorithm.sort;

public class SelectionSort implements Sort{

    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i=0;i<len;i++) {
            int s = nums[i];
            int index = 0;
            for (int j=i;j<len;j++) {
                if (nums[j]<=s) {
                    s = nums[j];
                    index = j;
                }
            }
            nums[index] = nums[i];
            nums[i] = s;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 1, 8, 5, 2, 7 };
        new SelectionSort().sort(nums);
        for (int i:nums) {
            System.out.println(i+" ");
        }
    }

}
