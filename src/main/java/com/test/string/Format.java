package com.test.string;

public class Format {

	public static void main(String args[]) {
//		String str = String.format("htttp://123.com"+"%s", "?toekn/12334");
//		System.out.println(str);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("1", "hola");
//		map.put("2", "siri");
//		for(String index:map.keySet()) {
//			System.out.println("key："+index);
//			System.out.println("value："+map.get(index));
//		}
//		String str = "HOLA";
//		switch(str.toLowerCase()) {
//		case "hola":
//			System.out.println("success");
//			break;
//		}
//		System.out.println(combinatStr("nodeId","taxonomy"));
//		int s = 5;
//		String ss = String.valueOf(s);
//		System.out.println("ss: "+ss);
//		Map<String, List<String>> macips = new HashMap<String, List<String>>();
//		List<String> ipList = new LinkedList<String>();
//		ipList.add("192.168.9.233");
//		macips.put("00:01:02:03:04:05", ipList);
//		String ipAddress = "";
//		String macAddress = "";
//		for (Map.Entry<String,List<String>> entry : macips.entrySet()){
//            if(entry.getValue().size()>0){
//            	ipAddress = entry.getValue().get(0);
//            }
//            macAddress = entry.getKey();
//        }
//		System.out.println("ip: "+ipAddress);
//		System.out.println("mac: "+macAddress);
//		String ip = "192.168.3.82";
//		String ipstr = ip.substring(0, ip.lastIndexOf('.'))+".0/24";
//		System.out.println(ipstr);
		String splitstr = "192.168.3.0|192.168.3.254|3|2000";
		String ip = splitstr.split("\\|")[2];
		System.out.println(ip);
	}
	private static String combinatStr(String str1, String str2) {
		return String.format("%s='"+str1+"' "+ "and" +" %s='"+str2+"'", str1, str2);
	}

}
