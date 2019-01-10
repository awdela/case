package com.test.algorithm.sort;

import java.util.Random;

/**
 * 算法思路：
 * 1.如果子节点大于父节点则交换，直到堆的最顶端是最大值
 * 2.然后把堆首（最大值）和堆尾互换，这样堆尾节点就是最大值
 * 3.将此节点从堆中去除，直到堆的尺寸为1
 */
public class HeapSort{

    public void sort(int[] nums) {
        int len = nums.length;
        buildMaxHeap(nums, len);
    }

    // 新建最大堆（每个节点的值都大于或等于其子节点的值）
    private void buildMaxHeap(int[] nums, int len) {
        for(int i =(int) Math.floor(len>>1);i>=0;i--) {
            heapify(nums, i, len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        int left = i<<1 + 1;
        int right = i<<1 + 2;
        int largest = i;
        if(left<len && nums[left]>nums[largest]) {
            largest = left;
        }
        if(right<len && nums[right]>nums[largest]) {
            largest = right;
        }
        if(largest!=i) {
            swap(nums, i, largest);
            heapify(nums, largest, len);
        }

    }

    private void swap(int[] arr, int i, int i2) {
        int tmp = arr[i];
        arr[i] = arr[i2];
        arr[i2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = new Random().nextInt(100);
        }
        new HeapSort().sort(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

}
