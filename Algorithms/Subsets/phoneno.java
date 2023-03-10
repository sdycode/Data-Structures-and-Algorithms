package Algorithms.Subsets;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class phoneno {
    public static void main(String[] args) {
        String digits = "29";
        // getListOfListofchar(digits);
        // List<String> list = new ArrayList<>();

        // list = letterCombinationsBrut(digits);
        // list = letterCombinationsBrut2(digits);
        // System.out.println(list);
        // System.out.println(letterCombinationsRecur("", digits, digits));
        // System.out.println(letterCombinationsRecurKKVideo("", digits));
        System.out.println(letterCombinationCountRecurKKVideo("", digits));
        // getStringForNo("7");
        // getStringForNo("2");
        // getStringForNo("8");
        // getStringForNo("9");

    }

    private static int letterCombinationCountRecurKKVideo(String p, String up) {
        int count = 0;
        if (up.isEmpty()) {
          return 1;
        } //
        int digit = up.charAt(0) - '0'; // it will conver '2' to 2 as ascii value operations are done
        // Now we will loop through characters present given digit like 2 - abc
        ArrayList<String> list = new ArrayList<>();
        int start = digit > 7 ? (digit - 2) * 3 + 1 : (digit - 2) * 3;
        int end = (digit - 1) * 3;
        if (digit == 7 || digit == 8) {
            end = (digit - 1) * 3 + 1;
        }
        if (digit == 9) {
            end = (digit - 1) * 3 + 2;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            count += letterCombinationCountRecurKKVideo(p + ch, up.substring(1));
     
        }
        return count;
    }

    private static List<String> letterCombinationsRecurKKVideo(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if (!p.isEmpty()) {
                list.add(p);
            }

            return list;
        } //
        int digit = up.charAt(0) - '0'; // it will conver '2' to 2 as ascii value operations are done
        // Now we will loop through characters present given digit like 2 - abc
        ArrayList<String> list = new ArrayList<>();
        int start = digit > 7 ? (digit - 2) * 3 + 1 : (digit - 2) * 3;
        int end = (digit - 1) * 3;
        if (digit == 7 || digit == 8) {
            end = (digit - 1) * 3 + 1;
        }
        if (digit == 9) {
            end = (digit - 1) * 3 + 2;
        }

        for (int i = start; i < end; i++) {
            char ch = (char) ('a' + i);
            list.addAll(letterCombinationsRecurKKVideo(p + ch, up.substring(1)));
        }
        return list;
    }

    private static String getStringForNo(String no) {
        if (no == "7" || no == "9") {
            int actno = (int) (Integer.parseInt(no));
            int add = no == "7" ? 0 : 1;

            char[] arr = new char[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = (char) ((actno - 2) * 3 + 'a' + i + add);
                System.out.println(arr[i]);
            }

            String ans = String.copyValueOf(arr);
            ;
            System.out.println(ans);
            return ans;
        } else {
            int add = no == "8" ? 1 : 0;

            int actno = (int) (Integer.parseInt(no));

            char[] arr = new char[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = (char) ((actno - 2) * 3 + 'a' + i + add);
            }
            String ans = String.copyValueOf(arr);
            ;
            System.out.println(ans);
            return ans;
        }
    }

    private static List<String> letterCombinationsRecur(String p, String up, String digits) {
        List<String> ans = new ArrayList<>();

        if (up.isEmpty()) {
            // p = p+up
            if (p.length() == digits.length()) {
                ans.add(p);
            }
            System.out.println(ans);
            return ans;
        }

        String no = getStringForNo(up.substring(0, 1));
        // System.out.println(no+ " "+up.substring(0, 1));
        for (int i = 0; i < no.length(); i++) {
            ans.addAll(letterCombinationsRecur(p + no.substring(i, i + 1), up.substring(1), digits));
        }

        return ans;

    }

    private static List<List<String>> getListOfListofchar(String s) {
        List<List<String>> outer = new ArrayList<>();

        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");

            }
        };

        for (int i = 0; i < s.length(); i++) {
            String letters = map.get(s.substring(i, i + 1));

            List<String> list = new ArrayList<>();

            for (int j = 0; j < letters.length(); j++) {
                list.add(letters.substring(j, j + 1));
            }

            outer.add(list);
        }
        System.out.println(outer);
        return outer;

    }

    private static List<String> letterCombinationsBrut2(String digits) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");

            }
        };

        for (int i = 0; i < digits.length(); i++) {

            int n = list.size();

        }

        List<List<String>> outer = new ArrayList<>();
        outer = getListOfListofchar(digits);
        List<String> finallList = new ArrayList<>();
        for (int i = 0; i < outer.size(); i++) {
            for (int j = 0; j < outer.get(i).size(); j++) {

            }
        }
        return list;
    }

    private static List<String> letterCombinationsBrut(String digits) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<String, String>() {
            {
                put("2", "abc");
                put("3", "def");
                put("4", "ghi");
                put("5", "jkl");
                put("6", "mno");
                put("7", "pqrs");
                put("8", "tuv");
                put("9", "wxyz");

            }
        };

        int totalNo = 1;
        for (int i = 0; i < digits.length(); i++) {
            String letters = map.get(digits.substring(i, i + 1));
            totalNo *= letters.length();
        }
        String letters = map.get(digits.substring(0, 1));
        for (int index = 0; index < totalNo; index++) {
            list.add(
                    letters.substring(index / letters.length(), index / letters.length() + 1));
        }
        System.out.println(list);
        System.out.println(totalNo);
        for (int j = 1; j < digits.length(); j++) {
            for (int i = 0; i < totalNo; i++) {

                String letter = map.get(digits.substring(j, j + 1));
                System.out.println(letter);
                String tempString = list.get(i);
                tempString += letter.substring(j, j + 1);
                list.set(i, tempString);
            }
            System.out.println(list);
        }
        return list;
        /*
         * for (int i = 0; i <digits.length(); i++) {
         * 
         * String letters = map.get(digits.substring(i, i+1));
         * System.out.println(letters);
         * 
         * for (int j = 0; j < letters.length(); j++) {
         * if (i > 0) {
         * int tempIndex= i*letters.length()+j;
         * String temp = list.get(tempIndex) +letters.substring(j, j + 1);
         * list.add(temp);
         * // String temp = letters.substring(j, j + 1);
         * // list.add(temp);
         * } else {
         * String temp = letters.substring(j, j + 1);
         * list.add(temp);
         * }
         * }
         * }
         * return list;
         * 
         */
    }

}
