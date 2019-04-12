package com.test.tw.trans;

import com.test.tw.trans.Graph.Node;

public class TranMain2 {

    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.addNextTown(nodeB, 5);
        nodeA.addNextTown(nodeD, 5);
        nodeA.addNextTown(nodeE, 7);

        nodeB.addNextTown(nodeC, 4);

        nodeC.addNextTown(nodeD, 8);
        nodeC.addNextTown(nodeE, 2);

        nodeD.addNextTown(nodeE, 6);
        nodeD.addNextTown(nodeE, 3);

        nodeE.addNextTown(nodeB, 3);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        int distance = Dijkstra.getPath(graph, nodeD, nodeE);
        System.out.println("shortestDistance is "+distance);
    }
}
