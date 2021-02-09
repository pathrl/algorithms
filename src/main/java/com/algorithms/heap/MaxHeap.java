package com.algorithms.heap;

import java.util.Arrays;

public class MaxHeap {

    // maximum element is the root of the tree
    private int[] arr;
    private int size;

    public MaxHeap(int[] arr) {
        this.size = arr.length;
        this.arr = arr;
        // Build heap (rearrange array) (NlogN)
        for (int i = size / 2 - 1; i >= 0; i--) { // N
            heapify(arr, size, i); // logN
        }
    }

    // insert element into the heap (logN)
    public void insert(int n) {
        size++;
        if (arr.length <= size) {
            arr = Arrays.copyOf(arr, 2 * arr.length);
        }

        // adjust bottom to top
        int idx = size - 1;
        if (idx > 0) {
            int idxParent = (idx % 2 == 0) ? (idx / 2) - 1 : idx / 2;
            arr[idx] = n;
            while (idxParent > -1 && arr[idxParent] <= n) {
                arr[idx] = arr[idxParent];
                arr[idxParent] = n;
                idx = idxParent;
                idxParent = (idxParent % 2 == 0) ? (idxParent / 2) - 1 : idxParent / 2;
            }
        } else {
            arr[0] = n;
        }
    }

    // removes root element (logN)
    public int[] pool() {
        size--;

        int root = arr[0];
        arr[0] = arr[size];
        arr[size] = root;

        if (size == 1) return arr;

        heapify(arr, size, 0);
        return arr;
    }

    // (logN)
    private void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        // If left child is larger than largest so far
        if (left < size && arr[left] > arr[largest]) largest = left;

        // If right child is larger than largest so far
        if (right < size && arr[right] > arr[largest]) largest = right;

        // If largest is not root
        if (largest != i) {
            swap(i, largest);
            heapify(arr, size, largest);
        }


    }

    private void swap(int i, int p) {
        int aux = arr[p];
        arr[p] = arr[i];
        arr[i] = aux;
    }
}
