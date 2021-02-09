package com.algorithms.sort;

import java.util.*;

public class MergeSort {

    public static int[] doMergeSort(final int[] arr) {
        if (arr.length < 2) return arr;
        final int middleArray = arr.length / 2;
        final int[] leftSide = Arrays.copyOfRange(arr, 0, middleArray);
        final int[] rightSide = Arrays.copyOfRange(arr, middleArray, arr.length);

        doMergeSort(leftSide);
        doMergeSort(rightSide);
        return sortArray(leftSide, rightSide, arr);

    }

    private static int[] sortArray(final int[]left, final int[] right, final int[] aux) {
        final int middleArray = aux.length / 2;
        int l = 0;
        int r = 0;
        int k = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                aux[k] = left[l];
                l++;
            }
            else {
                aux[k] = right[r];
                r++;
            }
            k++;
        }

        while (l < left.length) {
            aux[k] = left[l];
            l++;
            k++;
        }

        while(r < right.length){
            aux[k] = right[r];
            r++;
            k++;
        }
        return aux;
    }
}
