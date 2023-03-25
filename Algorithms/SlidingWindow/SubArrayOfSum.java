package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class SubArrayOfSum {

    public static void main(String[] args) {
        int[] arr =
//                {1, 2, 3};
//                {1,1,1};
//                {4, 1,1, 1, 2, 3, 2, 5, 2, 3};
                {-1,-1,1};
//                {10, -5, 15, 1, 1, 1, 2, 10, -10, 5, 1, 2, 3};
        int sum = 0;
        System.out.println(findLongestSubarraysWithGivenSumWithIJApproach(arr, sum));
//        subarraySumCount(arr, sum);
//        findLongestSubarraysWithGivenSumUsingHashMap(arr, sum);
    }

    private static int findLongestSubarraysWithGivenSumWithIJApproach(int[] arr, int k) {
        int countSubarrays = 0;

        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
//            if (sum < j) {
//                j++;
//                sum += arr[j];
//            }

            if (arr[j] == k && arr.length > 1) {
                countSubarrays++;
                System.out.println("Ans " + Arrays.toString(Arrays.copyOfRange(arr, j, j + 1)));
            }
            if (sum == k) {
                countSubarrays++;
                System.out.println("Ans " + Arrays.toString(Arrays.copyOfRange(arr, i, j + 1)));
            }
            if (sum >= k) {
                //increament i upto sum < k
                while (sum >= k) {
                    sum -= arr[i];
                    if (i + 1 < n) {
                        i++;
                    }

                }

            }
            System.out.println("end " + sum + " " + i + " " + j);
            j++;

        }
        return countSubarrays;
    }

    private static void findLongestSubarraysWithGivenSumUsingHashMap(int[] arr, int sumGiven) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = -1;
//      {10, -5, 15, 1, 1, 1, 2, 10, -10, 5, 2, 3};
        int finalStart = 0, finalEnd = 0;
        int maxLength = 0;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
//            System.out.println(arr[i] + " " + sum + " " + (sum - sumGiven) + "" + "" + map);

            if (sum - sumGiven == 0) {
                startIndex = 0;
                endIndex = i;
                finalStart = startIndex;
                finalEnd = endIndex;
                maxLength = finalEnd - finalStart;
                System.out.println("Ans is " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

//                break;
            }
            if (map.containsKey(sum - sumGiven)) {
                // we found our subarray
                startIndex = map.get(sum - sumGiven) + 1;
                endIndex = i;
                if (endIndex - startIndex > maxLength) {
                    finalStart = startIndex;
                    finalEnd = endIndex;
                    maxLength = finalEnd - finalStart;
                }
                System.out.println("Ans is " + startIndex + " " + i + "  " +

                        Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

            }


        }
        System.out.println("final ans is " + Arrays.toString(Arrays.copyOfRange(arr, finalStart, finalEnd + 1)));
    }


    private static void findSubarraysWithGivenSumUsingHashMap(int[] arr, int sumGiven) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = -1;
//      {10, -5, 15, 1, 1, 1, 2, 10, -10, 5, 2, 3};
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
//            System.out.println(arr[i] + " " + sum + " " + (sum - sumGiven) + "" + "" + map);

            if (sum - sumGiven == 0) {
                startIndex = 0;
                endIndex = i;
                System.out.println("Ans is    " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

//                break;
            }
            if (map.containsKey(sum - sumGiven)) {
                // we found our subarray
                startIndex = map.get(sum - sumGiven) + 1;
                endIndex = i;
                System.out.println("Ans is inmap " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

            }


        }
    }

    public static int subarraySumCount(int[] nums, int k) {
// from leetcode
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        //adding the first value
        map.put(0, 1);
        int count = 0;
//        {10, -5, 15, 1, 1, 1, 2, 10, -10, 5, 1, 2, 3};

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            //inorder to make a subarray with sum k, we need a complimantary preSum
            //complimentary preSum value should be preSum - k
            int comSum = preSum - k;
            //if this sum already was present in map then we can form a subarray
            System.out.println(i + " " + map);
            if (map.containsKey(comSum)) {
                //this is present so we can form a subarray
                //the count we cannot directly add one, because what if we had this complementary sum was presnt two times in the array then we can form two subarrays right, so we have to increment the count according to the number of times this complementary sm was present in the array
                count += map.get(comSum);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            } else {
                //this complementary sum is not present in the map so we cannot form req subaray with sum k
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }
        }
        return count;

    }

    private static int findNoofSubarraysWithGivenSumUsingHashMapNOTWorking(int[] arr, int sumGiven) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = -1;
        int count = 0;
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
//            System.out.println(arr[i] + " " + sum + " " + (sum - sumGiven) + "" + "" + map);

            if (sum - sumGiven == 0) {
                startIndex = 0;
                endIndex = i;
                count++;
                System.out.println("Ans is " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

//                break;
            }
            if (map.containsKey(sum - sumGiven)) {
                // we found our subarray
                startIndex = map.get(sum - sumGiven) + 1;
                endIndex = i;
                count++;
                System.out.println("Ans is " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex + 1)));

            }


        }
        return count;
    }

    private static void findSubarraysWithGivenSum(int[] arr, int sumGiven) {
        int n = arr.length;
        int count = 0;
        for (int k = 0; k < n; k++) {
            int sum = arr[k];
            for (int l = k + 1; l <= n; l++) {
                count++;
                if (sum == sumGiven) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, k, l)) + " sum " + sum);
                }
                if (l < n) {
                    sum += arr[l];
                }

            }
        }
        System.out.println("count " + count);
    }
}
