package com.test.string;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XmlTest {

	public static void main(String[] args) {

		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<snmp-info><community>lanyun123</community><maxRepetitions>2</maxRepetitions>"
				+ "<maxRequestSize>65535</maxRequestSize><maxVarsPerPdu>10</maxVarsPerPdu>"
				+ "<port>161</port><readCommunity>lanyun123</readCommunity><retries>1</retries>"
				+ "<timeout>1800</timeout><version>v2c</version><writeCommunity>private</writeCommunity>"
				+ "</snmp-info>";
		SAXBuilder buider = new SAXBuilder();
		try {
			Map<String, String> map = new HashMap<String, String>();
			Document document = buider.build(new StringReader(xmlStr));
			Element rootElem = document.getRootElement();
			List<Element> communities = rootElem.getChildren();
			for(Element community : communities) {
				if(community.getName().equals("community")) {
					map.put("community", community.getText());
				}
				if(community.getName().equals("readCommunity")) {
					map.put("readCommunity", community.getText());
				}
			}
			System.out.println(map.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
