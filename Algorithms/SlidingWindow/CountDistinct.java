package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class CountDistinct {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 3, 1, 1, 3};
        int k = 4;
        System.out.println(countDisitinctUsingMap(arr, k));
    }

    private static int[] countDisitinctUsingMap(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n - k + 1];
        int i = 0, j = 0;
        while (j < n) {
            if (j - i + 1 < k) {
                int count = map.containsKey(arr[j]) ? map.get(arr[j]) : 0;
                map.put(arr[j], count + 1);
                System.out.println("bef "+ map);
            }
            if (j - i + 1 == k) {
             if(i>0) {
                 int lastCount =  map.get(arr[i-1])-1;
                 if(lastCount<=0){
                     map.remove(arr[i-1]);
                 }else{
                     map.put(arr[i-1], map.get(arr[i-1])-1);
                 }
                }
                int count = map.containsKey(arr[j]) ? map.get(arr[j]) : 0;
                map.put(arr[j], count + 1);

                System.out.println("aft "+ map);

                i++;
            }
            j++;
         if(i>0)   ans[i-1]=map.size();
            System.out.println("size "+ Arrays.toString(ans));
        } return ans;
    }
}
