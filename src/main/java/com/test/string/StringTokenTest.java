package com.test.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.text.StrSubstitutor;
/**
 * 解决命令行中解析空格的问题
 * 有的命令中空格需要分开 有些需要在一起运行
 */
public class StringTokenTest {
	
	public static void main(String[] args) {
		List<String> command = new ArrayList<String>();
		//d eee为一个整体不能拆
		String commandStr = "\"/c/program files/tencent/qq/bin/qq.exe\" \"${SrcIP}\" \"d\" \"eee fff\" \"-df=${DstIP}\"";
		Map<String,String> params = new HashMap<String,String>();
		params.put("SrcIP", "192.168.3.1");
		params.put("DstIP", "192.168.3.2");
		StringTokenizer st = new StringTokenizer(commandStr, "\"") ;
		while(st.hasMoreTokens()) {
			String param = st.nextToken();
			if (!(param.trim().length() == 0)) {
				command.add(param);
				System.out.println("find: " + param+"\n");
			}
		}
		StrSubstitutor ss = new StrSubstitutor(params);
		String result = ss.replace(command);
		System.out.println("result: "+result);
	}

}
