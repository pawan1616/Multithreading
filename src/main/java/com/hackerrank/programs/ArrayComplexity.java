package com.hackerrank.programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayComplexity {

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 10, 2, 1, 15, 7 };
        // expected: _ 7 12 13
        String[] newList = new String[arr.length];

        ArrayList<Integer> indexes = new ArrayList<>();
        IntStream.range(0, arr.length).forEach(idx -> indexes.add(idx));

        // specific arr element has been occupied
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int indexToRemove = -1;
            int nextGreater = Integer.MAX_VALUE;

            for (Integer idx : indexes) {
                if (arr[idx] > element && arr[idx] < nextGreater) {
                    nextGreater = arr[idx];
                    indexToRemove = idx;
                }
            }

            if (indexToRemove >= 0) {
                newList[i] = String.valueOf(nextGreater);
                indexes.remove(Integer.valueOf(indexToRemove));
            } else {
                newList[i] = "_";
            }
        }

        Arrays.stream(newList).forEach(a -> {
            System.out.println(a);
        });
    }
}
