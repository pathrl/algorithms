package com.algorithms.quickFind;

import java.util.Arrays;

public class MainExercises {

    public static void main(String[] args) {
        System.out.println("Result quick union: " + exercise1());
    }

    private static long exercise1() {
        System.out.println("--------------------");
        System.out.println("Exercise 1: Social Network");
        Exercise1 exercise1 = new Exercise1(10);
        String logs =
                "1;0;1--" +
                "2;1;2--" +
                "3;4;5--" +
                "4;3;4--" +
                "5;7;9--" +
                "6;7;8--" +
                "7;4;6--" +
                "8;2;3--" +
                "9;7;4--" +
                "10;3;5--" +
                "11;1;3";

        String[] timestamps = logs.split("--");
        long timestamp = -1;
        for (String log : timestamps) {
            String[] splits = log.split(";");
            timestamp = Long.parseLong(splits[0]);
            int p = Integer.parseInt(splits[1]);
            int q = Integer.parseInt(splits[2]);

            timestamp = exercise1.weightedUnion(timestamp, p, q);
            if (timestamp > -1) return timestamp;
        }
        return timestamp;
    }
}
