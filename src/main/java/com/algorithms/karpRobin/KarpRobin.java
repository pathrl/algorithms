package com.algorithms.karpRobin;

public class KarpRobin {

    public static int doKarpRobinAlgorithm(String s, String t) {
        int matches = 0;
        int maxLength = t.length() - s.length();

        ADT sHash = new ADT();
        for (char c : s.toCharArray()) {
            sHash.append(c);
        }

        ADT tHash = new ADT();
        for (int i = 0; i < s.length(); i++) {
            tHash.append(t.charAt(i));
        }

        if (tHash.getHash() == sHash.getHash()) {
            matches++;
        }

        for (int i = s.length() - 1; i < t.length() - 1; i++) {
            int initChar = i - (s.length() - 1);
            int finalChar = i + 1;
            tHash.append(t.charAt(finalChar));
            tHash.skip(t.charAt(initChar));
            if (tHash.getHash() == sHash.getHash()) {
                if (s.equals(t.substring(initChar + 1, finalChar + 1))) {
                    matches++;
                }
            }
        }

        return matches;
    }
}
