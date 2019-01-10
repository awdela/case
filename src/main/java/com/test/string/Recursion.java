package com.test.string;

public class Recursion {

    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        String result = reverse("efreggfgd");
        System.out.print(result);
    }

}
