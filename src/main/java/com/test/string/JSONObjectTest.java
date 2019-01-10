package com.test.string;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JSONObjectTest {

    public static void main(String[] args) {

            String str = "{\r\n" +
                    "    \"deviceMetaId\": \"dem_centos7\",\r\n" +
                    "    \"deviceMethod\": \"ssh\",\r\n" +
                    "    \"deviceProperties\": {\r\n" +
                    "        \"deviceAddr\": \"\",\r\n" +
                    "        \"devicePort\": \"\",\r\n" +
                    "        \"deviceUser\": \"root\",\r\n" +
                    "        \"devicePassword\": \"{key_Dr3Hd8ZJQQajgPMmEY5pym}NPBubK6NB5t3HyYXQU8p4Z\"\r\n" +
                    "    }\r\n" +
                    "}";
            JSONObject attrJson = (JSONObject) JSONValue.parse(str);
            System.out.println("str:" + attrJson.toString() + "\n");
    }


}
