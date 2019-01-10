package com.test.algorithm.sort;

/**
 * 快速排序 思路：分治法，将数据分为几部分来同时处理 时间复杂度： O(nlogn)
 * 优化思路：DualPivotQuicksort使用两个Pivot将整个数组分为三段，从而进行优化 补充：
 */

public class QuickSort {

    /**
     * 快速排序实现
     */
    public static void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        sort(nums, low, high);
    }

    public static void sort(int[] nums, int low, int high) {
        if (low>=high) {
            return;
        }
        int i = low;
        int j = high;
        int pivot = nums[low];
        while (i < j) {
            // 先从后往前
            while(pivot<=nums[j] && j>i) {
                j--;
            }
            // 从前往后
            while(pivot>=nums[i] && j>i) {
                i++;
            }
            if (i<j) {
                swap(nums, i, j);
            }
        }
        nums[low] = nums[i];
        nums[i] = pivot;
        sort(nums, low, i-1);
        sort(nums, i+1, high);
    }

    private static void swap(int[] arr, int i, int i2) {
        int tmp = arr[i];
        arr[i] = arr[i2];
        arr[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {7,5,3,2,9,10,8,4,6,1};
        quickSort(nums);
        for (int i :nums) {
            System.out.println(i + " ");
        }
    }

}
