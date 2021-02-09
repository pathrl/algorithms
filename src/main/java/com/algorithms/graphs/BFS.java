package com.algorithms.graphs;

import java.util.*;
import java.util.Map;

public class BFS {

    public static String[] getShortestPath(Graph g, Node node, Node lastNode) {
        Map<Node, Integer> levels = new HashMap<>();
        levels.put(node, 0); // Start Level

        Map<Node, Node> parents = new HashMap<>();
        parents.put(node, null); // None parent

        List<Node> queue = new ArrayList<>(Collections.singletonList(node));
        int i = 1;

        while(!queue.isEmpty()) {
            List<Node> next = new ArrayList<>();
            for (Node v : queue) {
                Set<Node> adj = v.getAdjacentNodes().keySet();
                for (Node u : adj) {
                    if (levels.get(u) == null) { // check if it have been visited
                        levels.put(u, i);
                        parents.put(u, v);
                        next.add(u);
                    }
                }
            }
            queue = next;
            i++;
        }

        int size = levels.get(lastNode);
        Node parent = parents.get(lastNode);

        String[] result = new String[size + 1];
        result[size] = lastNode.getName();

        size--;
        while(parent != null) {
            result[size] = parent.getName();
            parent = parents.get(parent);
            size--;
        }

        return result;
    }

}
