package com.test.apache.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.commons.lang.text.StrSubstitutor;

public class StrSubstitutorTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("key1", "hello");
		params.put("key2", "kitty");
		params.put("key3", "hello");
		params.put("key4", "doggy");
		
		StrSubstitutor ss = new StrSubstitutor(params);
		List<String> command  = new ArrayList<String>();
		command.add("result");
		Iterator iter = params.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Entry) iter.next();
			command.add("${"+(String)entry.getKey()+"}");
		}
		String result = ss.replace(command);
		System.out.println(result);
		StringTokenizer st = new StringTokenizer(result, "[,]");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
//		String line = "#!/usr/bin/python";
//		if (line.contains("python")) {
//			System.out.println(line.substring(line.indexOf("/")));
//		}
	}
	
}
