package com.test.tw.trans;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.test.tw.trans.Graph.Node;

public class TransMain {

    private static final Graph graph = new Graph();
    private static Map<String, Node> nodeCache = new HashMap<>();;

    public static void init(String[] paths){
        for (String path : paths) {
            Node n1 = parse(path.substring(0, 1));
            Node n2 = parse(path.substring(1, 2));
            int distance = Integer.parseInt(path.substring(2, 3));
            n1.addNextTown(n2, distance);
        }
        for (Entry<String, Node> nodeEntry: nodeCache.entrySet()) {
            graph.addNode(nodeEntry.getValue());
        }
    }

    public static Node parse(String nodeStr) {
        if(nodeCache.get(nodeStr) != null) {
            return nodeCache.get(nodeStr);
        }else {
            Node node = new Node(nodeStr);
            nodeCache.put(nodeStr, node);
            return node;
        }
    }

    public static void main(String[] args) {
        String[] paths = new String[] { "AB5", "BC4", "CD8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        try {
            init(paths);
        } catch (Exception e) {
            System.out.println("graph is not a correct format String : " + graph.toString());
        }
        // Graph graph0 = Dijkstra.getPath(graph, nodeA);
        int shortestNode = Dijkstra.getPath(graph, nodeCache.get("A"), nodeCache.get("E"));
        System.out.println("shortestDistance is " + shortestNode);
    }
}
