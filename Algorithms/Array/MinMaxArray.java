package Algorithms.Array;

import java.util.Arrays;

public class MinMaxArray {
    
   
    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 9, 12, 18 };
        int[] arr2 = new int[arr1.length];

        // [2,12,4,9,6]
        brutForce(arr1, arr2);
        // System.out.println(arr2);

    }

    private static void brutForce(int[] arr1, int[] arr2) {
        int start = 0, end = arr1.length - 1;
        int i = 0;
        while (start <= end) {
            arr2[i] = arr1[start];
            if (i + 1 < arr1.length) {
                arr2[i + 1] = arr1[end];
            }

            start++;
            end--;
            System.out.println("i " + i);
            if (i + 2 < arr1.length) {
                i += 2;
            }

        }

        System.out.println(Arrays.toString(arr2));
    }

}
