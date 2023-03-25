package SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWthtRepetingChar {
    public static void main(String[] args) {
        String s =
                "dvdf";
//                "aabaab!bb";
//                "qrsvbspk";
//                "aab";
//                " ";
//                "pwwkew";
//                "abcabcbbcdeda";

//        System.out.println(LongestSubstringWthtRepetingCharWithHashMap(s));

        System.out.println(longestSubstringWthtRepetingCharWithHashMapIJApproach(s));
    }

    private static int longestSubstringWthtRepetingCharWithHashMapIJApproach(String str) {
// This approach is working in Leetcode perfectly
        // https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
        char[] arr = str.toCharArray();
        int n = arr.length;
        int count = 0, i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            // if equal window with map
            int ws = j - i + 1;
            if (map.size() < j - i + 1) {
                // remove i and increment i till map comes to window size
                while (map.size() < j - i + 1) {

                    if(map.getOrDefault(arr[i], 0)==1 ){
                        map.remove(arr[i]);
                    }else if( map.getOrDefault(arr[i], 0)!=0){
                        map.put(arr[j], map.get(arr[j] ) - 1);
                    }

                    i++;

                }
            }
            if (map.size() == j - i + 1) {
                count = Math.max(count, map.size());
            }
            j++;
        }
        System.out.println("ans  "+count);
        return count;
    }

    private static int LongestSubstringWthtRepetingCharWithHashMap(String str) {
        // ALL CASES ARE NOT PASSED
        char[] arr = str.toCharArray();
        int n = arr.length;
        int count = 0, i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
//            map.put(arr[j], map.getOrDefault(arr[j],0)+1);

            count = Math.max(count, map.size());
            if (map.getOrDefault(arr[j], 0) == 0) {
                // char not present so add it
                map.put(arr[j], 1);
            } else {
//                char already present so just increment i++
                if (arr[i] == arr[j]) {

                    i++;
                }
                System.out.println("bef i " + i + " j " + j + " " + map + " " + arr[i] + " " + arr[j]);
                if (i < j) {
                    while (arr[i] != arr[j]) {
                        map.remove(arr[i]);
                        i++;
                    }

                    map.put(arr[j], 1);

                }

            }
            System.out.println(" i " + i + " j " + j + " " + map);
            count = Math.max(count, map.size());
        }
        System.out.println("ans " + count);
        return count;
    }
}
