package com.algorithms.karpRobin;

public class ADT {

    private static final int firstPrimeASCII = 101;
    private int hash;

    public ADT() {
        hash = 0;
    }

    public void append(char c) {
        int ascii = (int) c;
        hash += ascii % firstPrimeASCII;
    }

    public void skip(char c) {
        int ascii = (int) c;
        hash -= ascii % firstPrimeASCII;
    }

    public int getHash() {
        return hash;
    }
}
