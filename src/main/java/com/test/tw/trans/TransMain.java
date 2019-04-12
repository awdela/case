package com.test.tw.trans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.test.tw.trans.Graph.Node;

public class TransMain {

    private static Graph graph = new Graph();
    private static Map<String, Node> nodeCache = new HashMap<>();
    private static Set<List<Node>> allPath = new HashSet<>();

    public static void init(String[] paths) {
        for (String path : paths) {
            path = path.trim();
            Node n1 = getNode(path.substring(0, 1));
            Node n2 = getNode(path.substring(1, 2));
            int distance = Integer.parseInt(path.substring(2, 3));
            n1.addNextTown(n2, distance);
        }
    }

    public static Node getNode(String nodeName) {
        if (nodeCache.get(nodeName) != null) {
            return nodeCache.get(nodeName);
        } else {
            Node node = new Node(nodeName);
            graph.addNode(node);
            nodeCache.put(nodeName, node);
            return node;
        }
    }

    public static void getDefinedRouteDistance(String[] nodes) {
        boolean findTheRoute = true;
        int distance = 0;
        if (nodes.length < 2) {
            System.out.println("NO SUCH ROUTE");
            return;
        }
        for (int i = 0; i < nodes.length - 1; i++) {
            Node preNode = nodeCache.get(nodes[i]);
            Node nextNode = nodeCache.get(nodes[i + 1]);
            Map<Node, Integer> nextNodes = preNode.getNextTownNodes();
            if (nextNodes.containsKey(nextNode)) {
                distance += nextNodes.get(nextNode);
                continue;
            } else {
                findTheRoute = false;
                break;
            }
        }
        if (findTheRoute) {
            System.out.println(distance);
        } else {
            System.out.println("NO SUCH ROUTE");
        }

    }

    public static void getRouteOnLimited(Node startNode, Node endNode, int steps) {
        getRouteOnLimited(startNode, endNode, steps, new LinkedList<>());
        Iterator<List<Node>> iter = allPath.iterator();
        while (iter.hasNext()) {
            List<Node> nodes = iter.next();
            System.out.println("path: ");
            for (Node node:nodes) {
                System.out.println(node.getName()+" ");
            }
            System.out.println("\n");
        }
    }

    public static void getRouteOnLimited(Node startNode, Node endNode, int steps, List<Node> nodes) {
        if (startNode.nextTownNodes.containsKey(endNode) || nodes.size()>0) {
            nodes.add(endNode);
            allPath.add(nodes);
            nodes.clear();
            return;
        }
        for (Entry<Node, Integer> nodeEntry : startNode.nextTownNodes.entrySet()) {
            nodes.add(startNode);
            Node NextNode = nodeEntry.getKey();
            nodes.add(NextNode);
            getRouteOnLimited(NextNode, endNode, steps--, nodes);
        }
    }

    public static void main(String[] args) {
        String[] paths = new String[] { "AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7" };
        try {
            init(paths);
//            getDefinedRouteDistance(new String[] { "A", "B", "C" });
//            getDefinedRouteDistance(new String[] { "A", "D" });
//            getDefinedRouteDistance(new String[] { "A", "D", "C" });
//            getDefinedRouteDistance(new String[] { "A", "E", "B", "C", "D" });
//            getDefinedRouteDistance(new String[] { "A", "E", "D" });
            getRouteOnLimited(nodeCache.get("A"), nodeCache.get("C"), 4);
            int shortestNode = Dijkstra.getPath(graph, nodeCache.get("A"), nodeCache.get("E"));
            System.out.println("shortestDistance is " + shortestNode);
        } catch (Exception e) {
            System.out.println("graph is not a correct format String : " + graph.toString());
        }
    }
}
