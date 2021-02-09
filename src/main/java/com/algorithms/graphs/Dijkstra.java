package com.algorithms.graphs;

import java.util.*;

public class Dijkstra {

    public static String[] getShortestPath(Graph g, Node firstNode) {
        // Initialization
        firstNode.setDistance(0);
        Set<Node> visitedNodes = new HashSet<>();
        HashMap<Node, Node> parents = new HashMap<>();
        parents.put(firstNode, null);
        Queue<Node> q = new PriorityQueue<>(g.getNodes().size(), Comparator.comparingInt(Node::getDistance));
        q.addAll(g.getNodes());

        while (!q.isEmpty()) {
            Node v = q.poll();
            Set<Node> adj = v.getAdjacentNodes().keySet();
            visitedNodes.add(v);
            for (Node u : adj) {
                if (!visitedNodes.contains(u)) {
                    int newDistance = v.getDistance() + v.getAdjacentNodes().get(u);
                    if (u.getDistance() >= newDistance) {
                        q.remove(u);
                        u.setDistance(newDistance); // shortest path between nodes
                        q.add(u);
                        parents.put(u, v); // predecessor --optional (?)
                    }
                }
            }
        }

        String[] result = new String[visitedNodes.size()];
        int i = 0;
        for (Node node : visitedNodes) {
            String parentNode = parents.get(node) != null ? parents.get(node).getName() : "START";
            result[i++] = parentNode + "->" + node.getName();
        }

        return result;

    }
}
