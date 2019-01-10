package com.test.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 将整数按位数切割成不同的数字，然后按每个位数分别比较
 */
public class RadixSort implements Sort {

    @Override
    public void sort(int[] nums) {
        int maxDigit = getMaxDigit(nums);
        radixSort(nums, maxDigit);
    }

    // 获取最高位数
    private int getMaxDigit(int[] nums) {
        int maxValue = getMaxValue(nums);
        return getNumLenght(maxValue);
    }

    // 最大值的最高位数
    private int getNumLenght(int maxValue) {
        if(maxValue == 0) {
            return 1;
        }
        int length = 0;
        for(long tmp = maxValue;tmp!=0;tmp/=10) {
            length++;
        }
        return length;
    }

    // 获取最大值
    private int getMaxValue(int[] nums) {
        int maxValue = nums[0];
        for(int i:nums) {
            if(i>maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    private Object radixSort(int[] nums, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for(int i =0; i<maxDigit; i++, dev*=10, mod*=10) {
            int[][] counter = new int[mod*2][0];
            for(int j=0; j<nums.length;j++) {
                int bucket = ((nums[j]%mod)/dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], nums[j]);
            }
            int pos = 0;
            for(int[] bucket:counter) {
                for(int value:bucket) {
                    nums[pos++] = value;
                }
            }
        }
        return nums;
    }

    // 自动扩容，并保存数据
    private int[] arrayAppend(int[] is, int i) {
        is = Arrays.copyOf(is, is.length+1);
        is[is.length-1] = i;
        return is;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = new Random().nextInt(100);
        }
        new RadixSort().sort(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

}
