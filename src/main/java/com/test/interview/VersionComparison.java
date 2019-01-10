package com.test.interview;

public class VersionComparison {

    /**
     * 比较版本号的大小,前者大则返回1,后者大返回-1,相等则返回0,异常返回-2
     */
    public static int comparision(String version1, String version2) {
        if (version1 != null && version2 != null) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");
            int len = v1.length > v2.length ? v2.length : v1.length;
            for (int i = 0; i < len; i++) {
                int strResult = compare(v1[i], v2[i]);
                if (strResult == 0) {
                    continue;
                } else {
                    return strResult;
                }
            }
            if (v1.length == v2.length) {
                return 0;
            }else {
                return v1.length > v2.length ? 1:-1;
            }
        } else {
            return -2;
        }
    }

    public static int compare(String s1, String s2) {
        if (StringToAscii(s1) > StringToAscii(s2)) {
            return 1;
        } else if (StringToAscii(s1) < StringToAscii(s2)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static int StringToAscii(String value) {
        try {
            return Integer.parseInt(value);
        }catch(NumberFormatException e) {
            int sum = 0;
            for(int i=0;i<value.length();i++) {
                sum+=value.charAt(i);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(comparision("3.1.2ac", "3.1.2bd"));
    }

}
