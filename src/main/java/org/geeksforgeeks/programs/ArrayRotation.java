package org.geeksforgeeks.programs;

public class ArrayRotation {

    private static void rotate(int[] arr, int d)
    {
        for (int i = 0; i < arr.length - d; i++)
        {
            int temp = arr[i];
            arr[i] = arr[i + d];
            arr[i + d] = temp;
        }
        
        /*for (int i = arr.length - d; i < arr.length - 1; i++)
        {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
        */
        for (int i : arr)
        {
            System.out.println(i);
        }
    }
    
    public static void main(String[] args)
    {
        ArrayRotation.rotate(new int[] {1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
