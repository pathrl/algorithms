package com.algorithms.sort;

public class QuickSort {

    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    public int[] doQuickSort(int low, int high) {
        if (low < high) {

            int pivot = partition(low, high);
            doQuickSort(low, pivot);
            doQuickSort(pivot+1, high);
        }

        return arr;
    }

    public int partition(int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            do {
                i++;
            } while(arr[i] <= pivot);

            do {
                j--;
            } while(arr[j] > pivot);

            if (i < j) swap(i, j);
        }
        swap(low,j);
        return j;
    }

    private void swap(int i, int p) {
        int aux = arr[p];
        arr[p] = arr[i];
        arr[i] = aux;
    }
}
