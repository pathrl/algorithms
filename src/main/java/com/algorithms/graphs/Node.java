package com.algorithms.graphs;

import java.util.HashMap;
import java.util.Map;

public class Node {
    private String name;
    private Integer distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes;

    public Node(String name) {
        this.name = name;
        adjacentNodes = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addAdjacentNode(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
}
