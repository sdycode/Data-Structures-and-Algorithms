package SlidingWindow;

/*
You are given an integer array nums and two integers indexDiff and valueDiff.

Find a pair of indices (i, j) such that:

i != j,
abs(i - j) <= indexDiff.
abs(nums[i] - nums[j]) <= valueDiff, and
Return true if such pair exists or false otherwise.



Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
Output: true
Explanation: We can choose (i, j) = (0, 3).
We satisfy the three conditions:
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
Output: false
Explanation: After trying all the possible pairs (i, j),
 we cannot satisfy the three conditions, so we return false.


 */
public class ContainsDuplicateHard {
    public static void main(String[] args) {
        int[] arr =
                {1,2,2,3,4,5};
//                {1,5,9,1,5,9};
//                {1, 2, 3, 1};
        int iDiff = 3;
        int vDiff = 0;

        System.out.println(checkDuplicates(arr, iDiff, vDiff));

    }

    private static boolean checkDuplicates(int[] arr, int iDiff, int vDiff) {
        int n = arr.length;
        int i = 0, j = i+1;
        while (j<n && i<n){
            int diff = Math.abs(arr[j]-arr[i]);
            System.out.println("dif "+diff + " i " + i +  "  "+ j );
            if(diff<=vDiff && Math.abs(i-j)>=iDiff){
                return  true;
            }
            if(diff>vDiff){
                if(i<=j){
                    i++;
                }

            }
            if(j<n){
                j++;
            }

        }

        return false;
    }
}
