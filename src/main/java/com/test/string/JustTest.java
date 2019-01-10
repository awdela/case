package com.test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JustTest {


    public static void main(String[] args) {
        System.out.println(getNodeJson("hello ","world ","once"));
        int[] levelPromotions;
        String level = "1=1,2=2,3=3,4=4,5=5";
        Map<Integer, Integer> levelMap = new TreeMap<Integer, Integer>();
        for(String kv[]:splitKVs(level)) {
            if ( kv.length==2 ) {
                levelMap.put(Integer.valueOf((kv[0].trim())), Integer.valueOf(kv[1].trim()));
            }
        }
        levelPromotions = new int[ levelMap.size()*2 ];
        int index=0;
        for(Integer key:levelMap.keySet()) {
            Integer val = levelMap.get(key);
            levelPromotions[index] = key;
            levelPromotions[index+1] = val;
            index+=2;
        }
    }

    public static List<String[]> splitKVs(String str){
        List<String[]> result = new ArrayList<String[]>();
        for(String p0:str.split("(,|;)\\s*")) {
            String kv[] = p0.split("\\s*(:|=)\\s*");
            result.add(kv);
        }
        return result;
    }

    private static String getNodeJson(String... params) {
        StringBuffer sb = new StringBuffer();
        sb.append(params[0]);
        sb.append(params[1]);
        return sb.toString();
    }


}
