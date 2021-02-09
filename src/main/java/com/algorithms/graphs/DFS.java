package com.algorithms.graphs;

import java.util.HashSet;
import java.util.Set;

public class DFS {

    private static final Set<Node> visitedNodes = new HashSet<>();

    public static String[] getReachableVerticesFromS(Graph g, Node s) {
        visitedNodes.add(s);
        DFSVisit(g, s);

        String[] result = new String[visitedNodes.size()];
        int i = 0;
        for (Node node: visitedNodes) {
            result[i++] = node.getName();
        }

        return result;
    }

    public static void DFSVisit(Graph g, Node s) {
        Set<Node> adjacent = s.getAdjacentNodes().keySet();

        for (Node v : adjacent) {
            if (!visitedNodes.contains(v)) {
                visitedNodes.add(v);
                DFSVisit(g, v);
            }
        }
    }
}
