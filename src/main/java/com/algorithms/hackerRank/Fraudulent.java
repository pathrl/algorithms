package com.algorithms.hackerRank;

import java.io.*;
import java.util.*;

public class Fraudulent {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int repetitions = expenditure.length - d;
        int notifications = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            list.add(expenditure[i]);
        }
        Collections.sort(list);

        int idxMedian = d / 2;

        for (int i = 0; i < repetitions; i++) {
            if (i > 0) {
                int indexToRemove = doBinarySearch(list, expenditure[i]);
                list.remove(indexToRemove);
                int indexToAdd = doBinarySearch(list, expenditure[d + i - 1]);
                list.add(indexToAdd, expenditure[d + i - 1]);
            }

           float median = list.get(idxMedian);
            if (d % 2 == 0) median = (float) ((median + list.get(idxMedian - 1)) / 2);

            float doubleMedian = 2 * median;
            if (expenditure[d + i] >= doubleMedian) notifications++;
        }
        return notifications;
    }

    static int doBinarySearch(List<Integer> list, int value) {
        int low = 0;
        int high = list.size() - 1;
        while(low <= high) {
            int i = (low + high) / 2;
            if (value > list.get(i)) low = i + 1; // RIGHT SIDE
            else if (value < list.get(i)) high = i - 1; // LEFT SIDE
            else return i; // FOUND
        }

        return low;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        scanner.close();
    }
}