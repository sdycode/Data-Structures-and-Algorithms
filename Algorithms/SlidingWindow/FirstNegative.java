package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegative {
    public static void main(String[] args) {
        int[] arr = new int[]
                {12, -1, -7, 8, -15, 30, 16, 28};
//                {2,-5,10,-6,-7,8};
        int k = 3;
        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[arr.length];
//        findFirstNegative(arr, list, k);
//        findFirstNegativeBrutForce(arr, list, k);
        ArrayList<Integer> list2 = new ArrayList<>();
        findFirstNegativeIJApproach(arr, list2, k);

    }

    private static void findFirstNegativeIJApproach(int[] arr, ArrayList<Integer> ans, int k) {
        int j = 0, i = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (j < arr.length) {

            if (arr[j] < 0) {
                queue.add(arr[j]);
            }
            j++;

            System.out.println("qu " + queue);

            if (j - i + 1 == k) {
                if (queue.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(queue.peek());
                }
                if (!queue.isEmpty() && arr[i] == queue.peek()) {
                    queue.remove();
                }
                i++;
            }
            System.out.println("ans " + ans);

        }

    }

    private static void findFirstNegativeBrutForce(int[] arr, ArrayList<Integer> ans, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int negNo = 0;
            for (int j = i; j < i + k; j++) {
                count++;
                if (arr[j] < 0) {
                    negNo = arr[j];
                    break;
                }
            }
            ans.add(negNo);
            System.out.println(ans + " " + count);
        }
        System.out.println("brut count " + count);
    }

    private static void findFirstNegative(int[] arr, ArrayList<Integer> ans, int k) {
        boolean isFirst = false;
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                isFirst = true;
                ans.add(arr[i]);
                break;
            }
        }
        int n = arr.length;
        for (int i = k; i < n; i++) {
            if (isFirst) {

            }
            if (arr[i] < 0) {
                ans.add(arr[i]);

            } else {
//                ans[i]=ans[i-1];
            }
            System.out.println(ans);
        }

    }
}
