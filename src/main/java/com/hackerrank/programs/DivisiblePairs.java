package com.hackerrank.programs;

public class DivisiblePairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int count = 0;
        
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if ((ar[i] + ar[j]) % k == 0)
                    count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(divisibleSumPairs(6, 3, new int[] {1, 3, 2, 6, 1, 2}));
    }

}
