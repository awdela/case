package com.test.algorithm.sort;

import java.util.Random;

/**
 * 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 * 按增量序列个数 k，对序列进行 k 趟排序；
 * 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort implements Sort{

    // 待理解
    @Override
    public void sort(int[] arr) {
        int gap = 1;
        while(gap<arr.length) {
            gap = gap*3+1;
        }
        while(gap>0) {
            for(int i = gap;i<arr.length;i++) {
                int tmp = arr[i];
                int j = i-gap;
                while(j>=0 && arr[j]>tmp) {
                    arr[j+gap] = arr[j];
                    j-=gap;
                }
                arr[j+gap] = tmp;
            }
            gap = (int) Math.floor(gap/3);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for(int i =0;i<20;i++) {
            nums[i] = new Random().nextInt(100);
        }
        new ShellSort().sort(nums);
        for (int i:nums) {
            System.out.println(i+" ");
        }
    }

}