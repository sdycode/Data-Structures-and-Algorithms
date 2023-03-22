package Array.Problems;
/*
Given an array arr[] of N positive integers. Push all the zeros of the given array to the right end of the array while maitaining the order of non-zero elements.
Example 1:
Input: N = 5 Arr[] = {3, 5, 0, 0, 4}
Output: 3 5 4 0 0
Explanation: The non-zero elements preserve their order while the 0 elements are moved to the right.
Example 2:
Input: N = 4 Arr[] = {0, 0, 0, 4}
Output: 4 0 0 0
Explanation: 4 is the only non-zero element and it gets moved to the left.
 */


import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        int[] arr =
//                {0,8,6,0,0,7,9,0};
//                {0, 0, 0, 4};
                {3, 5, 0, 0, 4};

        System.out.println(shiftZeros(arr));
    }

    private static int[] shiftZeros(int[] arr) {
        int lastPos = arr.length-1;
        int countZeros = 0;
        for (int j = 0; j <arr.length ; j++) {
            if(arr[j]==0){
                countZeros++;

            }
            System.out.println(Arrays.toString(arr));

        }

        for (int j = 0; j <countZeros ; j++) {
            if(arr[j]==0){

                for (int i = arr.length-1; i>0 ; i--) {
                    if(arr[i]!=0 && arr[i-1]==0){
                        int temp = arr[i]; arr[i]= arr[i-1];
                        arr[i-1]= temp;


                    }


                }
            }
            System.out.println(Arrays.toString(arr));

        }
//        for (int i = arr.length-1; i>0 ; i--) {
//            if(arr[i]!=0 && arr[i-1]==0){
//                int temp = arr[i]; arr[i]= arr[i-1];
//                arr[i-1]= temp;
//
////                System.out.println(" "+i+ "  "+arr[i]+ " "+arr[i-1]);
////                for (int j = lastPos; j >i ; j--) {
////
////                }
//            }
//            System.out.println(Arrays.toString(arr));
//
//        }
//        System.out.println("again");
//        for (int i = arr.length-1; i>0 ; i--) {
//            if(arr[i]!=0 && arr[i-1]==0){
//                int temp = arr[i]; arr[i]= arr[i-1];
//                arr[i-1]= temp;
//
////                System.out.println(" "+i+ "  "+arr[i]+ " "+arr[i-1]);
////                for (int j = lastPos; j >i ; j--) {
////
////                }
//            }
//            System.out.println(Arrays.toString(arr));
//
//        }
        return  arr;
    }
}
