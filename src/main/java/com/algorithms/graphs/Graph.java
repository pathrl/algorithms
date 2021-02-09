package com.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Node> nodes;


    public Graph() {
        nodes = new HashSet<>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
