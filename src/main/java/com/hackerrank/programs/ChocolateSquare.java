package com.hackerrank.programs;

public class ChocolateSquare {

    static int solve(int n, int[] s, int d, int m){
        
        int count = 0;
        for (int i = 0; i <= n - m; i++)
        {
            int sum = 0;
            for (int j = i; j <= i + m - 1; j++)
                sum += s[j];
            
            if (sum == d)
                count++;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(solve(1, new int[] {4}, 4, 1));
    }

}
