package com.algorithms.quickFind;

public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int number) { // cost N
        this.id = new int[number];
        for (int i = 0; i < number; i++) {
            id[i] = i;
        }
    }

    public boolean findIsConnected(int p, int q) { // cost 1
        return id[p] == id[q];
    }

    public void union(int p, int q) { // cost N
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
