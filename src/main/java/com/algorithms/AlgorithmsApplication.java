package com.algorithms;

import com.algorithms.graphs.*;
import com.algorithms.heap.MaxHeap;
import com.algorithms.karpRobin.KarpRobin;
import com.algorithms.sort.MergeSort;
import com.algorithms.peakFinder.PeakFinder;
import com.algorithms.sort.QuickSort;

import java.util.Arrays;

public class AlgorithmsApplication {

    public static void main(String[] args) {
        System.out.println("Result peak number: " + peakFinderProblem());
        System.out.println("Result merge sort algorithm: " + Arrays.toString(mergeSortProblem()));
        System.out.println("Result karp-robin algorithm: " + karpRobinProblem());
        System.out.println("Result BFS algorithm: " + Arrays.toString(BFSProblem()));
        System.out.println("Result DFS algorithm: " + Arrays.toString(DFSProblem()));
        System.out.println("Result Dijkstra algorithm: " + Arrays.toString(DijkstraProblem()));
        System.out.println("Result Max Heapify:" + Arrays.toString(maxHeapify()));
        System.out.println("Result Quick Sorty:" + Arrays.toString(quickSortProblem()));
    }

    /**
     * peak finder
     * @return peak int found
     */
    private static int peakFinderProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 1: Peak Finder");
        int[] a = {7,6,5,4,3,2,1};
        System.out.println("Request Array: " +  Arrays.toString(a));
        PeakFinder peakFinder = new PeakFinder(a);

        return peakFinder.findPeakNumber();
    }

    /**
     * merge sort
     * @return sorted int[]
     */
    private static int[] mergeSortProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 2: Sort array by merge sort algoritm");
        int[] a = {4,2,1,6,8,5,3,7};
        System.out.println("Request Array: " +  Arrays.toString(a));
        return MergeSort.doMergeSort(a);
    }

    /**
     * Karp-Robin
     * @return number of matches of pattern
     */
    private static int karpRobinProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 3: Find number of matches of string s to string t");
        String s = "aab";
        String t = "aaabaab" ;
        System.out.println("Pattern: " + s + ", String: " + t);
        return KarpRobin.doKarpRobinAlgorithm(s, t);
    }

    /**
     * Graphs problems
     * Breadth-First Search (BFS) Algorithm
     * @return int[] the shortest path found in the graph
     */
    private static String[] BFSProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 4: Find the shortest path of a graph");
        Graph graph = new Graph(); // UNDIRECTED GRAPH
        Node a = new Node("A"); // 0
        Node b = new Node("B"); // 1
        Node c = new Node("C"); // 2
        Node d = new Node("D"); // 3
        Node e = new Node("E"); // 4
        Node f = new Node("F"); // 5
        Node g = new Node("G"); // 6
        Node h = new Node("H"); // 7
        a.addAdjacentNode(b, 1);
        a.addAdjacentNode(d, 1);
        b.addAdjacentNode(a, 1);
        b.addAdjacentNode(c, 1);
        c.addAdjacentNode(b, 1);
        d.addAdjacentNode(a, 1);
        d.addAdjacentNode(f, 1);
        e.addAdjacentNode(f, 1);
        e.addAdjacentNode(g, 1);
        f.addAdjacentNode(e, 1);
        f.addAdjacentNode(h, 1);
        g.addAdjacentNode(e, 1);
        g.addAdjacentNode(h, 1);
        h.addAdjacentNode(f, 1);
        h.addAdjacentNode(h, 1);
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        System.out.println("Undirected graph request:");
        System.out.println("B -- A    E -- G");
        System.out.println("|    |    |    |");
        System.out.println("C    D -- F -- H");
        System.out.println("First node: A, Last node: H");
        return BFS.getShortestPath(graph, a, h);
    }

    /**
     * Graphs problems
     * Depth-First Search (DFS) Algorithm
     * @return int[] the reachable vertices from node s
     */
    private static String[] DFSProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 5: the reachable vertices from node s");
        Graph graph = new Graph(); // UNDIRECTED GRAPH
        Node a = new Node("A"); // 0
        Node b = new Node("B"); // 1
        Node c = new Node("C"); // 2
        Node d = new Node("D"); // 3
        Node e = new Node("E"); // 4
        Node f = new Node("F"); // 5
        Node g = new Node("G"); // 6
        Node h = new Node("H"); // 7
        a.addAdjacentNode(b, 1);
        a.addAdjacentNode(d, 1);
        b.addAdjacentNode(a, 1);
        b.addAdjacentNode(c, 1);
        c.addAdjacentNode(b, 1);
        d.addAdjacentNode(a, 1);
        d.addAdjacentNode(f, 1);
        e.addAdjacentNode(f, 1);
        e.addAdjacentNode(g, 1);
        f.addAdjacentNode(e, 1);
        f.addAdjacentNode(h, 1);
        g.addAdjacentNode(e, 1);
        g.addAdjacentNode(h, 1);
        h.addAdjacentNode(f, 1);
        h.addAdjacentNode(h, 1);
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        System.out.println("Undirected graph request:");
        System.out.println("B -- A    E -- G");
        System.out.println("|    |    |    |");
        System.out.println("C    D -- F -- H");
        System.out.println("Node: A");
        return DFS.getReachableVerticesFromS(graph, a);
    }

    /**
     * Graphs problems
     * Dijkstra Algorithm
     * @return int[] the reachable vertices from node s
     */
    private static String[] DijkstraProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 6: shortest path from node s");
        Graph graph = new Graph(); // DIRECTED GRAPH
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        a.addAdjacentNode(b, 10);
        a.addAdjacentNode(c, 3);
        b.addAdjacentNode(c, 1);
        b.addAdjacentNode(d, 2);
        c.addAdjacentNode(b, 4);
        c.addAdjacentNode(e, 2);
        d.addAdjacentNode(e, 7);
        e.addAdjacentNode(d, 9);
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        System.out.println("Undirected graph request:");
        System.out.println("A --> B --> D");
        System.out.println("|    /  /   |");
        System.out.println("|   /  /    |");
        System.out.println("|  /  /     |");
        System.out.println("| /  /      |");
        System.out.println("|/  /       |");
        System.out.println("C -- -- --> E");
        System.out.println("Node: A");
        return Dijkstra.getShortestPath(graph, a);
    }

    /**
     * Max Heap
     * @return sorted array
     */
    private static int[] maxHeapify() {
        System.out.println("--------------------");
        System.out.println("Exercise 7: Returns sorted array");
        // int[] arr = new int[]{50,30,20,15,10,8,16, 60};
        int[] arr = new int[]{1,3,5,2,4,6,7};
        MaxHeap heap = new MaxHeap(arr);

        System.out.println("Array: " + Arrays.toString(arr));
        heap.insert(23);
        for (int i = 0; i < 8; i++) {
            arr = heap.pool();
        }
        return arr;
    }

    /**
     * Quick sort
     * @return sorted array
     */
    private static int[] quickSortProblem() {
        System.out.println("--------------------");
        System.out.println("Exercise 8: Returns sorted array");
        int[] arr = new int[]{50,30,20,15,10,8,16,60, Integer.MAX_VALUE};
        //int[] arr = new int[]{10,16,8,12,15,6,3,9,5,Integer.MAX_VALUE};
        System.out.println("Array: " + Arrays.toString(arr));
        QuickSort quickSort = new QuickSort(arr);
        return quickSort.doQuickSort(0, arr.length);
    }
}
