package com.test.tw.trans;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

import com.test.tw.trans.Graph.Node;

public class Dijkstra {

    public static int getPath(Graph graph,Node start, Node target) {
        start.setDistance(0);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        unvisitedNodes.add(start);
        while (unvisitedNodes.size() != 0) {
            Node currentNode = getShortestDistanceTown(unvisitedNodes);
            if (currentNode.equals(target)) {
                return
            }
            unvisitedNodes.remove(currentNode);
            for (Entry<Node, Integer> nextTownNodeEntry : currentNode.getNextTownNodes().entrySet()) {
                Node nextTownNode = nextTownNodeEntry.getKey();
                Integer distance = nextTownNodeEntry.getValue();
                if (!unvisitedNodes.contains(nextTownNode)) {
                    getMinDistance(nextTownNode, distance, currentNode);
                    unvisitedNodes.add(nextTownNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return graph;
    }

    // get shortest distance from target nodes
    public static Node getShortestDistanceTown(Set<Node> unvisitedNodes) {
        Node shortestDistanceTown = null;
        int shortestDistance = Integer.MAX_VALUE;
        for (Node node : unvisitedNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < shortestDistance) {
                shortestDistance = nodeDistance;
                shortestDistanceTown = node;
            }
        }
        return shortestDistanceTown;
    }

    public static void getMinDistance(Node nextTownNode, Integer edgeWeigh, Node target) {
        Integer distance = target.getDistance();
        if (distance + edgeWeigh < nextTownNode.getDistance()) {
            nextTownNode.setDistance(distance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(target.getShortestPath());
            shortestPath.add(target);
            nextTownNode.setShortestPath(shortestPath);
        }

    }
}
