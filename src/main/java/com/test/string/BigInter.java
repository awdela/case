package com.test.string;

import java.text.DecimalFormat;

public class BigInter {

    public static void main(String args[]) {
        String d = "123.234566";
        DecimalFormat df = new DecimalFormat("#.00");
        String s = df.format(d);
        System.out.println(s);
    }

}
