package com.hackerrank.programs;

public class KangarooJump {

    private static int times = 1;
    private static int currentLimit = 10;
    private static int maxLimit = 10000;
    private static int lastLimit = 0;
    
    static String kangaroo(int x1, int v1, int x2, int v2) {
        
        if ((currentLimit  * times) % maxLimit == 0)
            return "NO";
        
        int maxCount = (currentLimit * times) % maxLimit;
        int num1 = calculateNumber(x1, v1, maxCount);
        int num2 = calculateNumber(x2, v2, maxCount);
        
        if (num1 >= num2)
        {
            while (lastLimit <= maxCount)
            {
                if (num1 == num2)
                    return "YES";
                
                num1 = calculateNumber(x1, v1, lastLimit);
                num2 = calculateNumber(x2, v2, lastLimit);
                lastLimit++;
            }
        }
        
        times++;
        return kangaroo(x1, v1, x2, v2);
    }
    
    private static int calculateNumber(int x1, int v1, int times)
    {
        return (v1 * times) + x1;
    }
    
    public static void main(String[] args) {
        System.out.println(kangaroo(4602, 8519, 7585, 8362));
    }

}
