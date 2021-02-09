package com.algorithms.peakFinder;

import java.util.Arrays;

public class PeakFinder2D {

    private int[][] matrix;

    public PeakFinder2D(final int[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Straight forward algorithm
     * Search e = array[max][array.length / 2]
     * check left size L (L <= e)
     * check right size R (R <= e)
     * check top size T (T <= e)
     * check bottom size B (B <= e)
     * @return peak number
     */
    public int findPeakNumber() {
        int [][] auxMatrix = matrix;

        int rowPosition = -1;
        int columnPosition = -1;

        while(rowPosition < 0 && columnPosition < 0) {
            final int currentColumn = auxMatrix[0].length / 2;

            int[] column = new int[auxMatrix[0].length];
            for(int i = 0; i<auxMatrix.length; i++) {
                column[i] = auxMatrix[i][currentColumn];
            }
            final int currentRow = findPositionMaxNumber(column);


        }

        return (rowPosition < 0 && columnPosition < 0) ? -1 : auxMatrix[rowPosition][columnPosition];
    }

    private int findPositionMaxNumber(int[] numbers) {
        int result = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            final int next = numbers[i];
            if(result < next) result = next;
        }
        return result;
    }
}
