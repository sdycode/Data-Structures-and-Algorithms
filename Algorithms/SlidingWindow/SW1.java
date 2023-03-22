package SlidingWindow;

public class SW1 {
    public static void main(String[] args) {
        // Find max sum for subarray of size
        int[] arr = new int[]{2, 4, 8, 7, 6, 3, 9, 4};
        int k = 3;
        System.out.println(findMaxSumofSubarray(arr, k));
        System.out.println(findMaxSumofSubarrayWithijMethod(arr, k));

    }

    private static int findMaxSumofSubarrayWithijMethod(int[] arr, int k) {
        int maxSum = 0;

        int i = 0, j = 0, sum = 0;
        while (j < arr.length) {

            sum += arr[j];
            if(j-i == k){
                sum -=  arr[i];
                maxSum = Math.max(sum, maxSum);
                i++;
            }
            j++;
        }
        return maxSum;
    }

    private static int findMaxSumofSubarray(int[] arr, int k) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];

            maxSum = Math.max(sum, maxSum);
//            System.out.println("sum " + sum + "  " + maxSum);
        }

        return maxSum;
    }
}
