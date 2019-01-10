package com.test.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述:假设有x个数,每次去掉在三的整数倍上的数，取n此后，x还剩余哪两个数
 *
 */
public class GuoMei {

    public static int func(int n) {
        n = 10;
        List<Integer> num = new ArrayList<Integer>();
        for (int i=0;i<n;i++) {
            num.add(i);
        }
        int index = 0;
        while (num.size()>2) {


            index = (index+0)%num.size();
            num.remove(index);
        }
        System.out.println(num.get(0));
        System.out.println(num.get(1));
        return num.get(0);
    }

    public static void main(String[] args) {
        func(10);

    }

}
