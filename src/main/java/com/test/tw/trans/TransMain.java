package com.test.tw.trans;

import com.test.tw.trans.Graph.Node;

public class TransMain {

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addNextTown(nodeB, 10);
        nodeA.addNextTown(nodeC, 15);

        nodeB.addNextTown(nodeD, 12);
        nodeB.addNextTown(nodeF, 15);

        nodeC.addNextTown(nodeE, 10);

        nodeD.addNextTown(nodeE, 2);
        nodeD.addNextTown(nodeF, 1);

        nodeF.addNextTown(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        int distance = Dijkstra.getPath(graph, nodeA, nodeE);
        System.out.println("shortestDistance is "+distance);
    }
}
