package com.test.string;

public class Unicode2String {

    public static void main(String[] args) {
        // "\u53d1\u73b0\u6f0f\u6d1e" "\u6f0f\u6d1e\u5df2\u7ecf\u8fc7\u671f"
//        String s = "Windows\\u4ec5\\u5b89\\u5168\\u66f4\\u65b0 (2018.08)";
        String s = "Windows\\u4ec5\\u5b89\\u5168\\u66f4\\u65b0 (2018.08)";
        System.out.println(s + '\n');
        s = s.replace("\\\\", "\\");
        System.out.println(s + '\n');
        System.out.println(unicode2String(s));
    }

    public static String unicode2String(String unicode) {
        if (unicode.isEmpty()) {
            return null;
        }
        StringBuilder builder = new StringBuilder(unicode.length());
        for (int i=0;i<unicode.length();i++) {
            if (unicode.charAt(i)=='\\') {
                if(unicode.length() > i+6 && unicode.charAt(i+1)=='u') {
                    String data = unicode.substring(i+2, i+6);
                    builder.append((char)Integer.parseInt(data, 16));
                    i = i+5;
                }
            }else {
                builder.append(unicode.charAt(i));
            }
        }
        return builder.toString();
    }

}
