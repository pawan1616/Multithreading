package com.hackerrank.programs;

import java.util.Arrays;

public class BertrandPostulate {

    private static boolean isPrime[] = new boolean[100];
    public static boolean isNumberBertrandPostulate(int n)
    {
        if (n < 4)
            return false;
        
        boolean bertrandPostulateNumber = false;
        for (int i = n; i < 2 * n - 2; i++)
        {
            if (isPrime[i])
            {
                System.out.println("prime numbers "+i);
                bertrandPostulateNumber = true;
            }
        }
        return bertrandPostulateNumber;
    }
    
    public static void main(String[] args) {
        
        Arrays.fill(isPrime, Boolean.TRUE);
        isPrime[1] = Boolean.FALSE;
        isPrime[0] = Boolean.FALSE;
        
        for (int i = 2; i < isPrime.length; i += (i % 2 == 0? 1 : 2))
        {
            
            for (int j = i + i; j < isPrime.length; j += i)
            {
               isPrime[j] = Boolean.FALSE;
            }
        }
        
        System.out.println(BertrandPostulate.isNumberBertrandPostulate(40));
    }
}
