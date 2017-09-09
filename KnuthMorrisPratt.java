package com.example.java;

/*
Knuth-Morris-Pratt

Time complexity: O(m+n), m=length of text, n=length of pattern

Space complexity: O(n)
*/

public class KnuthMorrisPratt {


    public int search(String text, String pattern){

        int patternMatchArray [] = patternArray(pattern);
        int i = 0;
        int j = 0;

        while(i < text.length()){

            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                if(j!=0) j = patternMatchArray[j-1];
                else i++;
            }
            if(j==pattern.length()) return i-j;
        }
        return -1;
    }

    // build pattern Array
    private int[] patternArray(String pattern){

        int patternArray [] = new int[pattern.length()];

        patternArray[0]=0;

        int i = 1;
        int j = 0;

        while(i < pattern.length()){
            if(pattern.charAt(i)!=pattern.charAt(j)){
                if(j==0){
                    patternArray[i]= 0;
                    i++;
                }else{
                    j = patternArray[j-1];
                }
            }else{
                patternArray[i] = j+1;
                i++;
                j++;
            }
        }
        return patternArray;
    }


}
