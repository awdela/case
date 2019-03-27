package com.test.tw.trans;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Set<Node> nodes = new HashSet<>();

    static class Node{
        private String name;
        private List<Node> shortestPath = new LinkedList<>();
        private Integer distance = Integer.MAX_VALUE;
        Map<Node, Integer> nextTownNodes = new HashMap<>();

        public Node(String name) {
            this.setName(name);
        }

        public void addNextTown(Node town, int distance) {
            nextTownNodes.put(town, distance);
        }

        public Map<Node, Integer> getNextTownNodes() {
            return nextTownNodes;
        }

        public void setNextTownNodes(Map<Node, Integer> townNodes) {
            this.nextTownNodes = townNodes;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getShortestPath() {
            return shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath) {
            this.shortestPath = shortestPath;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }


}
