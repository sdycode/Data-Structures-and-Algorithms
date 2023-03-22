package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class SubArrayOfSum {

    public static void main(String[] args) {
        int[] arr = {10, -5, 15, 10, -10, 5};
        int sum = 5;
//        findSubarraysWithGivenSum(arr, sum);
        findSubarraysWithGivenSumUsingHashMap(arr, sum);
    }

    private static void findSubarraysWithGivenSumUsingHashMap(int[] arr, int sumGiven) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int startIndex = 0;
        int endIndex = -1;

        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            map.put(sum, i);
//            System.out.println(arr[i] + " " + sum + " " + map);

            if (sum - sumGiven == 0) {
                startIndex = 0;
                endIndex = i;
                System.out.println("Ans is " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex+1)));

//                break;
            }
            if (map.containsKey(sum - sumGiven)) {
                // we found our subarray
                startIndex = map.get(sum - sumGiven);
                endIndex =i ;
                System.out.println("Ans is " + startIndex + " " + i + "  " + Arrays.toString(Arrays.copyOfRange(arr, startIndex, endIndex+1)));

            }


        }
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
