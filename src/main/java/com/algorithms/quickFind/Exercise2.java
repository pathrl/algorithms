package com.algorithms.quickFind;

/**
 * Question 2 Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that
 * find(i) returns the largest element in the connected component containing i.
 * The operations union(), connected(), and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9
 * for each of the four elements in the connected components.
 */
public class Exercise2 {

    private int[] id;
    private int[] size;

    public Exercise2(int N) {
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

    public int find(int p) {
        if (id[p] == p && size[p] == 1) return p;
        else {
            for (int i = id.length - 1; i<p; i--) {
                if (isConnected(i, p)) return p;
            }
        }

        return p;
    }
}
