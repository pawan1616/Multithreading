package com.hackerrank.programs;

import java.math.BigInteger;

public class SubStringFinder {

    private static BigInteger exponent = new BigInteger("10").pow(9).add(new BigInteger("7"));
    
    public static int calculateLength(String x, String y)
    {
        int start = 0;
        int end = 0;
        int longestLength = 0;

        while (start < y.length()) {
            int length = 0;
            while (end < y.length()
                    && x.indexOf(y.substring(start, end + 1)) > -1) {
                length++;
                end++;
            }

            if (length > 0) {
                if (length > longestLength)
                    longestLength = length;

                start = end;
            } else
                start++;
        }
        return longestLength;
    }
    
    public static int substringAddition(String n)
    {
        StringBuilder n2 = new StringBuilder(n);
        
        BigInteger num = BigInteger.ZERO;
         
        /*int start = 0;
        while (start < n2.length())
        {
           
           int end = start;
           while (end < n.length())
           {
               num = num.add(new BigInteger(n2.substring(start, end + 1)));
               end++;
           }
           
          // int end = start;
          // num = num.add(new BigInteger(n2.substring(start, end + 1)));
           start++;
        }
        */
        return num.mod(exponent).intValue();
    }
    
    
    public static void main(String[] args) {
//       System.out.println(substringAddition("6300789549454074869713025721170113291167212711"
//               + "39829179349572383637541443562605787816"+
//                "06111036085360074421257207207387198523322868167701948"
//                + "87959155926131365585386974193691"
//                + "5896141380413900486094968371175676410640884374632431"));
        
        System.out.println(substringAddition("23"));
    }
}
