package com.algorithms.hackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Triplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        final int NUMBER_OF_TRIPLETS = 3;
        Map<Long, Long> result = new HashMap<>();

        for (Long number : arr) {
            if (number == 1)  {
                long count = result.getOrDefault(0L, 0L);
                result.put(0L, count + 1);
            }
            else if (number % r == 0) {
                long exponential = 0;
                if (r > 1) exponential = (long) (Math.log(number) / Math.log(r));
                long count = result.getOrDefault(exponential, 0L);
                result.put(exponential, count + 1);
            }
        }

        long triplets = 0;
        int n = arr.size();
        System.out.println(result.size());
        if (result.size() == 1) {
            for(Long value : result.values()) {
                triplets = (value * (value - 1) * (value - 2)) / 6;
            }
        }
        if (result.size() > 3) {
            triplets = result.size() - NUMBER_OF_TRIPLETS + 1;
            for(Long value : result.values()) {
                if (value > 1) triplets *= value;
            }
        }

        return triplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        bufferedReader.close();
    }
}
