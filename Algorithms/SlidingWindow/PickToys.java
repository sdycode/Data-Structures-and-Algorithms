package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;

public class PickToys {
    public static void main(String[] args) {
        // Problem is longest substring of k unique charcters
        // this is exact same as  LongestSubstringWithKUniqueChars
        String s = "aabacbebebe";
        int k = 2;
        System.out.println(findLongestSubstringsWithKUniqueCharsUsingHashMap(s, k));
        ;

    }


    private static int findLongestSubstringsWithKUniqueCharsUsingHashMap(String str, int k) {

        char[] arr = str.toCharArray();
        int n = arr.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int s = 0;
        int maxLength =0;
        for (int i = 0; i < n; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.size() == k) {
                maxLength= Math.max(maxLength,i-s+1);
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr,s,i+1))+ " "+(i-s+1));
            }
            if (map.size() > k) {
                while (map.size() > k && s + 1 < i) {
                    Character c = arr[s];

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
