package com.test.algorithm.consistant;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 一致性hash算法(来源于网络)
 * 暂不支持虚拟节点
 * 虚拟节点其实就是将真实节点拆分成若干个 但是每个虚拟节点都对应一个真实节点
 */
public class ConsistantHash {

    /**
     * 待加入hash环中的服务器列表
     */
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
                            "192.168.0.3:111", "192.168.0.4:111"};

    /**
     * hash环
     * 使用sortMap的目的是：
     * 可以自动排序 并且最快的找到离hash值最近的服务器
     */
    private static final SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    static {
        for(String server:servers) {
            addNode(server);
        }
    }

    // 添加节点到hash环中（但不包括虚拟节点）
    public static void addNode(String node) {
        sortedMap.put(hash(node), node);
    }

    public static void removeNode(String node) {
        sortedMap.remove(hash(node));
    }

    public static String getServer(String node) {
        // 得到路由节点的hash值
        int hash = hash(node);
        // 得到大于该hash值的所有map
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        // 第一个key就是顺时针过去离node最近的那个节点
        Integer i = subMap.firstKey();
        return subMap.get(i);
    }

    /**
     * 使用FNV1_32_HASH算法计算服务器hash值
     */
    private static Integer hash(String server) {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for(int i=0;i<server.length();i++) {
            hash = (hash ^ server.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        //如果是负数则取绝对值
        if(hash<0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        String[] nodes = {"127.0.0.1:1111", "221.226.0.1:2222", "10.211.0.1:3333"};
        for (int i = 0; i < nodes.length; i++)
            System.out.println("[" + nodes[i] + "]的hash值为" +
                    hash(nodes[i]) + ", 被路由到结点[" + getServer(nodes[i]) + "]");
    }

}
