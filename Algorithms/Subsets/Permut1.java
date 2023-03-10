package Algorithms.Subsets;

import java.util.*;

public class Permut1 {

    public static void main(String[] args) {

        String s = "abc";
        // getAllCombinationsBrut(s);
        List<String> ans = new ArrayList<>();

        // getAllStringsAfterAddingSingleChar("abc", "d");
        getAllCombinationsRec1("", s, ans);
        System.out.println(ans);

    }

    private static List<String> getAllCombinationsRec1(String p, String up, List<String> ans) {

        if (up.length() == 0) {
            ans.add(p);
            return ans;
        }

        // List<String> temp = getAllStringsAfterAddingSingleChar(str, s.substring(0,
        // 1));
        // for (int i = 0; i < temp.size(); i++) {
        // getAllCombinationsRec1(temp.get(i), s.substring(1), ans);
        // }
        // OR
        for (int i = 0; i <= p.length(); i++) {

            getAllCombinationsRec1(p.substring(0, i) + up.substring(0, 1) + p.substring(i), up.substring(1), ans);
        }

        return ans;
    }

    private static List<String> getAllStringsAfterAddingSingleChar(String org, String c) {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < org.length() + 1; i++) {
            list.add(org.substring(0, i) + c + org.substring(i));
        }
        System.out.println(list);

        return list;
    }

    private static void getAllCombinationsBrut(String s) {

    }

}
