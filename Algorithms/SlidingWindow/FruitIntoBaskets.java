package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

/*
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick
 */
public class FruitIntoBaskets {
    public static void main(String[] args) {
        // It is same as  LongestSubstringWithKUniqueChars or Pick Toys just here is array instead of String
// Just small change as in map.size <= k (here)
        int[] arr =

                {1,1};
//                {0};
//                {1,2,3,2,2};
        int k =2; // as we have only 2 baskets

        System.out.println(findLongestSubstringsWithKUniqueCharsUsingHashMap(arr, k));





    }
    private static int findLongestSubstringsWithKUniqueCharsUsingHashMap(int[] arr, int k) {


        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int maxLength =0;
        if(n<2){
return  1;
        }
        for (int i = 0; i < n; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (map.size() <= k) {
                maxLength= Math.max(maxLength,i-s+1);
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr,s,i+1))+ " "+(i-s+1));
            }
            if (map.size() > k) {
                while (map.size() > k && s + 1 < i) {
                    int c = arr[s];

                    if (map.containsKey(c)) {
                        if (map.get(c) == 0) {
                            map.remove(c);
                        } else {
                            map.put(c, map.get(c) - 1);
                            if(map.get(c)==0){
                                map.remove(c);
                            }
                        }


                    }
                    s++;
                }
            }
        }

        return  maxLength;
    }

}
