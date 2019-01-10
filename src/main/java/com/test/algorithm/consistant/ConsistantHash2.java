package com.test.algorithm.consistant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 一致性hash算法 by zgf
 */

public class ConsistantHash2 {

    private static final Logger logger = LoggerFactory.getLogger(ConsistantHash2.class);

    private String[] rooms;

    private List<String> targets;

    public ConsistantHash2(int roomCount) {
        this.rooms = new String[roomCount];
    }

    /**
     * 是否ROOM全空
     */
    public boolean isRoomClean() {
        for(int i=0;i<rooms.length;i++) {
            if ( !StringUtils.isEmpty(rooms[i])) {
                return false;
            }
        }
        return true;
    }

    public String getRoom(int hashCode) {
        if(logger.isDebugEnabled()) {
            logger.debug("HashCode is:"+hashCode+" , rooms length is:"+rooms.length);
        }
        return rooms[Math.abs(hashCode)%rooms.length];
    }

    public List<String> getRooms() {
        return Arrays.asList(rooms);
    }

    /**
     * 返回每个Target的映射空间数量统计
     */
    public Map<String,Integer> getTargetRoomCount(){
        Map<String, Integer> result = new TreeMap<>();
        for(String roomTarget:rooms) {
            if ( StringUtils.isEmpty(roomTarget) ) {
                continue;
            }
            Integer count = result.get(roomTarget);
            if ( count==null ) {
                count = 1;
            }else {
                count += 1;
            }
            result.put(roomTarget, count);
        }
        return result;
    }

    public String getRoomsAsJson() {
        JSONArray json = new JSONArray();
        for(int i=0;i<rooms.length;i++) {
            json.add(rooms[i]);
        }
        return json.toString();
    }

    public void setRoomsFromJson(String jsonStr) {
        if ( StringUtils.isEmpty(jsonStr) ) {
            hashClear();
            return;
        }
        JSONArray json = (JSONArray)JSONValue.parse(jsonStr);
        String[] rooms = new String[json.size()];
        for(int i=0;i<json.size();i++) {
            rooms[i] = (String)(json.get(i));
        }
        this.rooms = rooms;
    }

    /**
     * 设置新的Target
     * @param newTargets
     * @return 返回 target/roomCount
     */
    public void setTargets(List<String> newTargets) {
        if (newTargets == null || newTargets.size() == 0) {
            hashClear();
            return;
        }
        if (targets == null) {
            hashInit(newTargets);
        }else if (!targets.equals(newTargets)) { // 如果targets不变, 不重新计算
            // 找到 新增, 删除, 已有 targets
            List<String> added = new ArrayList<>(), deleted = new ArrayList<>(), remains = new ArrayList<>(),
                    oldTargets = new ArrayList<>();
            oldTargets.addAll(targets);

            for (String newt : newTargets) {
                if (oldTargets.remove(newt)) {
                    // 已存在
                    remains.add(newt);
                } else {
                    added.add(newt);
                }
            }
            deleted.addAll(oldTargets);

            int[] targetRooms = rehash(newTargets);
            logger.info("Hash with targets: "+newTargets+", added: "+added+", deleted: "+deleted+", target rooms: "+Arrays.stream(targetRooms).boxed().collect(Collectors.toList()));
        }
    }

    /**
     * 初始化分配
     */
    private void hashInit(List<String> newTargets) {
        targets = new ArrayList<>(newTargets);
        // 第一次, 均分
        int targetCount = targets.size();
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = targets.get(i % targetCount);
        }
    }

    /**
     * 清除分配空间
     */
    private void hashClear() {
        targets = null;
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = null;
        }
    }

    /**
     * 一致性HASH计算
     */
    private int[] rehash(List<String> newTargets) {
        targets = newTargets;
        // 每个target最大room数
        int maxRoomsPerTarget = rooms.length / newTargets.size();
        // 每个target的room数
        int[] targetRooms = new int[newTargets.size()];
        // 第一轮清除多余的target room
        LinkedList<Integer> blankRooms = recycleTargetRooms(newTargets, maxRoomsPerTarget, targetRooms);

        // 第二轮设置新的target
        for(int i=0;i<newTargets.size();i++) {
            String target = newTargets.get(i);
            int targetRoomCount = targetRooms[i];
            if ( targetRoomCount>=maxRoomsPerTarget ) {
                continue;
            }
            while(targetRoomCount<maxRoomsPerTarget) {
                Integer roomIndex = blankRooms.poll();
                if ( roomIndex==null ) {
                    break;
                }
                rooms[roomIndex] = target;
                targetRoomCount++;
            }
            targetRooms[i] = targetRoomCount;
        }

        //最后如果还有分配不掉的
        int targetIndex=0;
        while( !blankRooms.isEmpty() ) {
            int roomIndex = blankRooms.poll();
            int targetIndex0 = targetIndex%newTargets.size();
            String target = newTargets.get(targetIndex0);
            rooms[roomIndex] = target;
            targetRooms[targetIndex0]++;
        }
        return targetRooms;
    }

    private LinkedList<Integer> recycleTargetRooms(List<String> keepTargets, int maxRoomsPerTarget, int[] targetRooms)
    {
        LinkedList<Integer> blankRooms = new LinkedList<>();
        for(int i=0;i<rooms.length;i++) {
            String room = rooms[i];
            if ( null!=room ) {
                int targetIndex = keepTargets.indexOf(room);
                if ( targetIndex>=0 ) {
                    if ( targetRooms[targetIndex]<maxRoomsPerTarget ) {
                        targetRooms[targetIndex]++;
                        continue;
                    }
                }
            }
            rooms[i] = null;
            blankRooms.add(i);
        }
        return blankRooms;
    }


}
