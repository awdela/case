package com.test.algorithm.sort;

import java.util.Random;

public class InsertSort implements Sort {

    @Override
    public void sort(int[] nums) {
        // 默认第一个是有序的 所以从第二个开始排序
        for (int i=1;i<nums.length;i++) {
            // 记录要插入的数据
            int tmp = nums[i];
            // 从已经排好序的最右边比较，找到比其小的数
            int j = i;
            while(j>0&&tmp<nums[j-1]) {
                nums[j] = nums[j-1];
                j--;
            }
            // 位置不重合并且存在比其小的数，插入
            if(j!=i) {
                nums[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for(int i =0;i<20;i++) {
            nums[i] = new Random().nextInt(100);
        }
        new InsertSort().sort(nums);
        for (int i:nums) {
            System.out.println(i+" ");
        }
    }

}
