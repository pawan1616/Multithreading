package com.hackerrank.programs;

public class ScoreCounter {

    public static void main(String[] args) {
        breakingRecords(new int[] {3, 4, 21, 36, 10, 28, 35, 5, 24, 42});
    }

    static int[] breakingRecords(int[] score) {
       int[] counter = new int[2];
       
       int lowest = score[0];
       int maximum = score[0];
       
       for (int i = 1; i < score.length; i++)
       {
           if (score[i] > maximum)
           {
               maximum = score[i];
               counter[0]++;
           }
           else if (score[i] < lowest)
           {
               lowest = score[i];
               counter[1]++;
           }
       }
       return counter;
    }
}
