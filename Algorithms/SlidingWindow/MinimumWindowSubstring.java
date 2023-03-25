package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/minimum-window-substring/

HARD level

Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s =
                "abc";
//                "ADOBECODEBANC";
                String                  t =
                        "ac";
//                        "ABC";
        System.out.println("final "+getMinimumWindowSubstring(s, t));
    }

    private static String getMinimumWindowSubstring(String s, String t)

    {

        String ans = "";
        int finalStart = 0;
        int finalEnd = 0;
        int maxlength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> orgMap = new HashMap<>();
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            orgMap.put(t.charAt(k), orgMap.getOrDefault(t.charAt(k), 0) + 1);
            temp.put(t.charAt(k), temp.getOrDefault(t.charAt(k), 0) + 1);

        }
//        System.out.println(orgMap);
//        System.out.println(map);
//        System.out.println(map.equals(orgMap));
        for (; j < s.length(); j++) {
//            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            // check and decreament j from org if present
            if (!temp.containsKey(s.charAt(i))) {
                i++;
            }
            if (orgMap.containsKey(s.charAt(j))) {
                System.out.println("contains "+ i+ " " + j + "  " + s.charAt(j) + " "+orgMap);
                if (orgMap.get(s.charAt(j)) == 0) {
                    orgMap.remove(s.charAt(j));
//                    System.out.println("org " + orgMap);
                    if (orgMap.isEmpty()) {
                        ans = s.substring(i, j + 1);
                        if (j - i < maxlength) {
                            finalEnd = j + 1;
                            finalStart = i;
                            maxlength = finalEnd - finalStart;
                        }
//                        System.out.println("Ans if " + ans);
                        orgMap = (HashMap<Character, Integer>) temp.clone();
//                        System.out.println("org  aft " + orgMap);
                        i = j + 1;
                        map.clear();
                    }
                } else {
                    orgMap.put(s.charAt(j), orgMap.get(s.charAt(j)) - 1);
                    if (orgMap.get(s.charAt(j)) == 0) {
                        orgMap.remove(s.charAt(j));
                        System.out.println("orgr " + orgMap);
                    } System.out.println("orgr " + orgMap + " " +orgMap.isEmpty());
                    if (orgMap.isEmpty()) {
                        ans = s.substring(i, j + 1);
                        if (j - i < maxlength) {
                            finalEnd = j + 1;
                            finalStart = i;
                            maxlength = finalEnd - finalStart;
                        }
                        System.out.println("Ans  else " + ans + " " + i + " " + j+" "+finalStart+" "+finalEnd);
                        orgMap = (HashMap<Character, Integer>) temp.clone();

                        i = j + 1;
                        map.clear();
//                        System.out.println("org  aftr " + orgMap + " " + i + " " + j);
                    }
                }


            }

            System.out.println("Ans  last " + ans + " " + i + " " + j+" "+finalStart+" "+finalEnd);

            if (j < t.length()) {

            } else if (map.size() == orgMap.size() && orgMap.isEmpty()) {
//
                if (map.equals(orgMap)) {
                    ans = s.substring(j, i + 1);
                    System.out.println("Ans " + ans);
                    if (j - i < maxlength) {
                        finalEnd = j + 1;
                        finalStart = i;
                        maxlength = finalEnd - finalStart;
                    }
                }
            }

        }
        if (finalEnd - finalStart > s.length()) {
            return "";
        }
        return s.substring(finalStart, finalEnd);

    }
}
