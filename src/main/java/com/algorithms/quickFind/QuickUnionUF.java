package com.algorithms.quickFind;

/**
 * Like a tree
 * Root of a tree id[id[id[...i]]] if index and id[index] is the same
 * Find: if p and q have the same root
 * Union: set id of p's root to the id of q's root
 */
public class QuickUnionUF {

    private int[] id;
    // weighted union improve
    private int[] size;

    public QuickUnionUF(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(final int p) { // worst case N
        int i = p;
        while (id[i] != i) {
            // weighted union improve
            // Make every other node in path point to its grandparent (thereby halving path length).
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean isConnected(final int i, final int j) { // worst case N, with weighted union improvement logN
        return root(i) == root(j);
    }

    public void union(final int p, final int q) { // worst case N
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /**
     * Same as QuickUnion
     * but the lower tree change the root instead of the greater tree
     * Guarantee that no item is to far of the root
     */
    public void weightedUnion(final int p, final int q) { // cost logN
        int i = root(p);
        int j = root(q);

        if (i == j) return;

        if  (size[i] < size[j]) {
            id[i] = j; size[j] += size[i];
        } else {
            id[j] = i; size[i] += size[j];
        }
    }
}
