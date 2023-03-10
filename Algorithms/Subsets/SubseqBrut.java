package Algorithms.Subsets;

import java.util.ArrayList;

// Find all subsets of given array or string [order is presereved]
public class SubseqBrut {
    public static void main(String[] args) {
        String s = "bacs";

        System.out.println(getAllStringSubsetsBrut1(s));

    }

    private static ArrayList<String> getAllStringSubsetsBrut1(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        int c = 0;
        // System.out.println(s.subSequence(0, 4));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                if (!s.subSequence(i, j).toString().isEmpty()) {
                    ans.add(s.subSequence(i, j).toString());
                }

            }
        }
        System.out.println(ans.size());
        return ans;
    }

}
