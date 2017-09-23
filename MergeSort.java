package com.example.java;

/*
MergeSort
 Time complexity: best: nlog(n), average: nlog(n), worst: nlog(n)
 Space complexity: O(n)
 */

public class MergeSort {

    private int[] array;
    private int[] temp;
    private int length;

    public void sort(int[] array){
        this.array = array;
        this.length = array.length;
        this.temp = new int[length];

        sort(0, length-1);
    }

    private void sort(int start, int end){
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        sort(start, mid);
        sort(mid+1, end);
        merge(start, mid, end);
    }

    private void merge(int start, int mid, int end){

        // copy both subarrays into temp array
        for(int i = start; i <= end; i++){
            temp[i] = array[i];
        }

        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end){

            if(temp[left] <= temp[right]){
                array[index] = temp[left];
                left++;
            }else{
                array[index] = temp[right];
                right++;
            }
            index++;
        }

        // copy the reminder elements on the left side
        while(left <= mid){
            array[index] = temp[left];
            left++;
            index++;
        }
        // any left over elements on the right side should be in place
    }



}
