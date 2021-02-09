package com.algorithms.quickFind;

/**
 * Question 3 Successor with delete.
 * Given a set of S={0,1,...,n−1} and a sequence of requests of the following form:
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y ≥ x.
 * design a data type so that all operations (except construction) take logarithmic time or better in the worst case.
 */
public class Exercise3 {

    private int[] id;
    private int[] size;

    public Exercise3(int N) {
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

    public boolean remove(final int p) {
       if (id[p] == -1) return false;

       id[p] = -1;
       return true;

    }

    public int findSuccessor(final int p) {
        int i = p + 1;
        int successor = p;
        while(successor == p && i < id.length) {
            if (id[i] > -1) successor = id[i];
            i++;
        }
        return successor;
    }

    public boolean isConnected(final int i, final int j) {
        return root(i) == root(j);
    }

    public void weightedUnion(final int p, final int q) {
        int i = root(p);
        int j = root(q);

        if (size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];

        }
    }
}
