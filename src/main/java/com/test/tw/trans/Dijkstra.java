package com.test.tw.trans;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.test.tw.trans.Graph.Node;

public class Dijkstra {

    public static Graph getPath(Graph graph, Node target) {
        target.setDistance(0);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        unvisitedNodes.add(target);
        while (unvisitedNodes.size() != 0) {
            Node currentNode = getShortestDistanceTown(unvisitedNodes);
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

    public static int getPath(Graph graph, Node start, Node target) {
        int shortestDistance = Integer.MAX_VALUE;
        List<Node> shortestPath = new LinkedList<>();
        start.setDistance(0);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();

        unvisitedNodes.add(start);
        while (unvisitedNodes.size() != 0) {
            Node currentNode = getShortestDistanceTown(unvisitedNodes);
            unvisitedNodes.remove(currentNode);
            for (Entry<Node, Integer> nextTownNodeEntry : currentNode.getNextTownNodes().entrySet()) {
                Node nextTownNode = nextTownNodeEntry.getKey();
                Integer distance = nextTownNodeEntry.getValue();
                if (!unvisitedNodes.contains(nextTownNode)) {
                    getMinDistance(nextTownNode, distance, currentNode);
                    if (nextTownNode.equals(target)) {
                        shortestDistance = nextTownNode.getDistance();
                        shortestPath = nextTownNode.getShortestPath();
                        shortestPath.add(target);
                        System.out.println(shortestPath.toString());
                    }
                    unvisitedNodes.add(nextTownNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return shortestDistance;
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
