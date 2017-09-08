package com.example.java;

/*
RabinKarpSearch

 Time complexity: O(m*n), m=length of text, n=length of pattern
 Space complexity: O(1)

 */

public class RabinKarpSearch {

    private static final int PRIME = 11;

    public int search(String text, String pattern) {

        long patternHash = createHash(pattern);
        long textHash = createHash(text.substring(0, pattern.length()));

        for (int i = 0; i < text.length() - pattern.length(); i++) {

            if (i != 0) {
                textHash = (textHash - text.charAt(i - 1)) / PRIME;
                textHash += text.charAt(i + pattern.length() - 1) * Math.pow(PRIME, pattern.length() - 1);
            }
            if (patternHash == textHash) return i;

        }
        return -1;
    }

    private long createHash(String text) {
        long hash = 0;
        for (int i = 0; i < text.length(); i++) {
            hash += text.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

}
