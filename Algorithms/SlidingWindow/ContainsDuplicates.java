package SlidingWindow;

import java.util.HashMap;

/*
https://leetcode.com/problems/contains-duplicate-ii/
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array such that
nums[i] == nums[j] and abs(i - j) <= k.

Input: nums = [1,2,3,1], k = 3
Output: true

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] arr =
                {1,2,3,1,2,3};
//                {1,0,1,1};
//                {1, 2, 3, 1};
        int k = 2;
        System.out.println(checkDuplicates(arr, k + 1));

    }

    private static boolean checkDuplicates(int[] arr, int k) {

// Working correct code on leetcode
        int i = 0, j = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            if (map.getOrDefault(arr[j], 0) > 0) {
                return true;
            }
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            if (j - i + 1 == k) {
                if (map.getOrDefault(arr[i], 0) > 0) {
                    map.put(arr[i], map.get(arr[i]) - 1);
                } else {
                    map.remove(arr[i]);
                }
                i++;
            }
            System.out.println(map);


            j++;
        }
        return false;
    }
}
