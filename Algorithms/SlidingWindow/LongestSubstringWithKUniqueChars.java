package SlidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithKUniqueChars {

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 2;
        System.out.println(findLongestSubstringsWithKUniqueCharsUsingHashMap(s, k));
        ;
//        System.out.println(longestSubstringForAtleastKTimeRepeatingChar(s,k));

    }

    private static int longestSubstringForAtleastKTimeRepeatingChar(String str, int k) {
        int maxCount = 0;

        char[] arr = str.toCharArray();
        int n = arr.length;
        HashMap<Character, Integer> map = new HashMap<>();
        int s = 0;

        for (int i = 0; i < n; i++) {

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.size() == k) {
                System.out.println(Arrays.toString(Arrays.copyOfRange(arr,s,i+1)));
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

        return  maxCount;
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
