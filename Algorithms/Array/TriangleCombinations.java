package Array;

import java.util.Arrays;

public class TriangleCombinations {
    /*
    Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles.
    Example 1:
    Input: n = 3 arr[] = {3, 5, 4}
    Output: 1
    Explanation: A triangle is possible with all the elements 5, 3 and 4.
    Example 2:
    Input: n = 5 arr[] = {6, 4, 9, 7, 8}
    Output: 10
    Explanation: There are 10 triangles possible with the given elements like (6,4,9), (6,7,8),.
     */
    public static void main(String[] args) {
        int[] arr = {6, 4, 9, 7, 8};
//        System.out.println(getNoOfTrianlges(arr));
        System.out.println(getNoOfTrianlgesBrutForce(arr));
    }

    private static int getNoOfTrianlgesBrutForce(int[] arr) {
        // This is O(n3)
        int count = 0;
        if (arr.length < 3) {
            return 0;
        }
        int n= arr.length;Arrays.sort(arr);
//        int i = 0, j = 1, k = 2;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if(isTrianlge(arr, i,j,k)){
                        count++;
                        System.out.println("tri "+arr[i]+" "+arr[j]+" "+arr[k]+ " count "+count);

                    }else{
//                        break;
                    }

                }

            }
        }
        return  count;
    }

    private static int getNoOfTrianlges(int[] arr) {
        int count = 0;
        if (arr.length < 3) {
            return 0;
        }
        int i = 0, j = 1, k = 2;

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        while (k < arr.length) {
            if (isTrianlge(arr, i, j, k)) {
                System.out.println("tri "+arr[i]+" "+arr[j]+" "+arr[k]);
                count++;
                k++;
            } else {
                j++;
                k++;

            }
        }

        return count;
    }

    private static boolean isTrianlge(int[] arr, int i, int j, int k) {
        return arr[k] < arr[i] + arr[j];
    }
}
