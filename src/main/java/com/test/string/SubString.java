package com.test.string;

public class SubString {

	public static void main(String[] args) {

//	    String url = "http://10.255.7.16:8080/rest/openapi/session?%E7%94%A8%E6%88%B7%E5%90%8D=test_anquan&%E5%AF%86%E7%A0%81=test_anquan";
//        try {
//            String urlName = URLDecoder.decode(url,"utf-8") ;
//            System.out.println(urlName);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//		String s = "fewfew";
//		System.out.println(s.substring(s.length()-2));

	    String s = "dwdewq?a";
	    String s1="";
	    if (s.indexOf('?')>=0) {
	        StringBuilder builder = new StringBuilder();
	        builder.append(s.substring(0,s.indexOf('?'))).append(s1).append("ssssss");
	        System.out.println(builder.toString());
	    }else {
	        System.out.println("not match");
	    }
	}

}
