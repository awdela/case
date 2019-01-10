package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneTest {

    public static void main(String[] rags) {
        // String content = "15600026083";
        // String pattern =
        // "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        // boolean isMatch = Pattern.matches(pattern, content);
        // System.out.println(isMatch);

        String content = "   2097152      521732     1575420";
        String pattern = "(\\s*)(\\d*)(\\s*)(\\d*)(\\s*)(\\d*)";
        // boolean isMatch = Pattern.matches(pattern, content);
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        if (m.find()) {
            System.out.println("re: " + m.group(6));
        }
    }

}
