package com.hackerrank.programs;

class CommonFactor {

   static int getTotalX(int[] a, int[] b) {

        int smallest = findGCD(b);
        int largest = findlcm(a);
        int counter = (smallest % largest == 0 ? 1 : 0);

        
        for (int num = 2; num <= smallest / 2; num++) {
            if (smallest % num == 0 && (smallest / num) % largest == 0) {
                counter++;
            }
        }

        return counter;
    }

    static int findGCD(int arr[])
    {
        int num = arr[0];
        
        for (int i = 1; i < arr.length; i++)
        {
            num = gcd(num, arr[i]);
        }
        
        return num;
    }
    
    private static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int findlcm(int arr[])
    {
        // Initialize result
       int ans = arr[0];
     
       for (int i = 1; i < arr.length; i++)
            ans = (((arr[i] * ans)) /
                    (gcd(arr[i], ans)));
     
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(getTotalX(new int[] {1}, new int[] {100}));
    }

}
