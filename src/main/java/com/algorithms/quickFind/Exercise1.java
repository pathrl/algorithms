package com.algorithms.quickFind;

/**
 * Question 1 Social network connectivity.
 * Given a social network containing n members and a log file containing
 * m timestamps at which times pairs of members formed friendships,
 * design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend).
 * Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 * The running time of your algorithm should be mlogn or better and use extra space proportional to n.
 */
public class Exercise1 {

    private int[] id;
    private int[] size;

    public Exercise1(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(final int p) {
        int i = p;
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(final int i, final int j) {
        return root(i) == root(j);
    }

    public long weightedUnion(final long timestamp, final int p, final int q) { // cost logN
        int i = root(p);
        int j = root(q);

        if (i == j) return -1;

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }

        if (size[j] == id.length) return timestamp;
        else if (size[i] == id.length) return timestamp;
        else return -1;
    }
}
