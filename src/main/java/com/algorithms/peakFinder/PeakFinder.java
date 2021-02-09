package com.algorithms.peakFinder;

import java.util.Arrays;

public class PeakFinder {

    private int[] array;

    public PeakFinder(final int[] array) {
        this.array = array;
    }

    /**
     * Straight forward algorithm
     * Search e = array[array.length / 2]
     * check left size L (L <= e)
     * check right size R (R <= e)
     * @return peak number
     */
    public int findPeakNumber() {
        int[] auxArray = Arrays.copyOf(array, array.length);

        int positionResult = -1;

        while(positionResult < 0) {
            final int currentPosition = auxArray.length / 2;
            final int leftPosition = (currentPosition > 0) ? currentPosition - 1 : 0;
            final int rightPosition = (currentPosition < auxArray.length -1) ? currentPosition + 1 : auxArray.length - 1;

            if (auxArray[currentPosition] < auxArray[leftPosition]) {
                auxArray = Arrays.copyOfRange(auxArray, 0, currentPosition);
            }
            else if (auxArray[currentPosition] < auxArray[rightPosition]) {
                auxArray = Arrays.copyOfRange(auxArray, rightPosition, auxArray.length);
            }
            else {
                positionResult = currentPosition;
            }
        }

        return (positionResult > -1) ? auxArray[positionResult] : positionResult;
    }
}
