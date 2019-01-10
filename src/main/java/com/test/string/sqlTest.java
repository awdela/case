package com.test.string;

public class sqlTest {
	
	public static void main(String[] args) {
		String fields[] = {"id","name","no"};
		StringBuilder query = new StringBuilder(128);
        query.append("SELECT ");
//        boolean appendComma = true;
//        for (int i=0;i<fields.length;i++) {
//        	query.append(fields[i]).append(" ");
//            if (appendComma) {
//                query.append(", ");
//            }
//            if(i == fields.length-2) {
//            	appendComma =false;
//            }
//        }
        boolean appendComma = false;
        for(String field: fields) {
        	 if (appendComma) {
                 query.append(", ");
             }
            query.append(field).append(" ");
            appendComma = true;
        }
        System.out.println(query);
	}

}
