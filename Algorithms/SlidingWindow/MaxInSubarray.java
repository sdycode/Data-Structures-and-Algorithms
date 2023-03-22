package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxInSubarray {

    public static void main(String[] args) {
        int[] arr =
                {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
//                {1, 3, -1, -3, 5, 3, 6, 7};
//                {2, 3, -1, 3, 8, 5, 6, 7, -2};
//        ans =     [3, 3, 8, 8, 8, 7, 7]
        int k = 7;
        System.out.println(getArrayOfMaxInSubArrayBrutForce(arr,k));
        System.out.println(Arrays.toString(getArrayOfMaxInSubArrayUsingDeque(arr, k)));
//        printMax(arr,k);
//        System.out.println(Arrays.toString(printMax(arr, k)));
    }

    private static int[] getArrayOfMaxInSubArrayBrutForce(int[] arr, int k) {

        int ansArrSize = arr.length - k + 1;
        int[] ans = new int[ansArrSize];
        int countLoop = 0;
        int i = 0;// window no
        while (i < ansArrSize) {
            int max = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                countLoop++;
                max = Math.max(max, arr[j]);
            }
            ans[i] = max;
            i++;
        }
        System.out.println("countLoop " + countLoop);
        System.out.println(Arrays.toString(ans));
        return ans;
    }


    private static int[] getArrayOfMaxInSubArrayUsingDeque(int[] arr, int k) {
        int[] ans = new int[arr.length - k + 1];
        int i = 0, j = 0, n=arr.length;

        Deque<Integer> deque = new ArrayDeque<>();
        while (j<n){
            if(j-1+1<k){
                // remove peek element if current j is greater than peek
                if(!deque.isEmpty() && deque.peek()<arr[j]){
                    deque.removeFirst();

                }
                while (!deque.isEmpty() && deque.getLast()< arr[j]){
                    deque.removeLast();
                }
                if(j-1+2<k){
                    deque.add(arr[j]);
                }

//                System.out.println("window "+deque);
            }
            if(j-i+1==k){


//                System.out.println(i+ " ans " +Arrays.toString(ans) + " i "+i + " j "+ j +" "+ arr[i]);
//                ans[i]= deque.peek();
                // remove peek of deque if it equal to arr[i]
                if(!deque.isEmpty() &&  i>0&& deque.peek()==arr[i-1]){
                    deque.removeFirst();
                }

//                System.out.println("before "+deque +" "+arr[j]);
                // Before adding arr[j] new useful element remove smaller element than arr[j] from last side
                while (!deque.isEmpty() && deque.getLast()< arr[j]){
                    deque.removeLast();
                }

                deque.addLast(arr[j]);
//                System.out.println("after "+deque);
                ans[i]= deque.peek();
//                System.out.println(i+ " ans after " +Arrays.toString(ans) );

                i++;
            }
//            System.out.println( "ans after i " +Arrays.toString(ans));
            j++;
        }
            return ans
                    ;
    }
    static int[] printMax(int arr[], int K) {
        int N = arr.length;
        int[] ans = new int[N - K + 1];

        // Create a Double Ended Queue, Qi
        // that will store indexes of array elements
        // The queue will store indexes of
        // useful elements in every window and it will
        // maintain decreasing order of values
        // from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()]
        // are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        /* Process first k (or first window)
        elements of array */
        int i;
        for (i = 0; i < K; ++i) {

            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty()
                    && arr[i] >= arr[Qi.peekLast()])

                // Remove from rear
                Qi.removeLast();

            // Add new element at rear of queue
            Qi.addLast(i);
        }

        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (; i < N; ++i) {

            // The element at the front of the
            // queue is the largest element of
            // previous window, so print it
            ans[i - K] = arr[Qi.peek()];
            System.out.print(arr[Qi.peek()] + "[" + (i - K) + "] ");

            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peek() <= i - K)
                Qi.removeFirst();

            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty())
                    && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();

            // Add current element at the rear of Qi
            Qi.addLast(i);
        }

        // Print the maximum element of last window
        ans[i - K] = arr[Qi.peek()];
        System.out.print(arr[Qi.peek()]);
        return ans;
    }

}
