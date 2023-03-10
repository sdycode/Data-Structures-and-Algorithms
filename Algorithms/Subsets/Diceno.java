package Algorithms.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Diceno {
    public static void main(String[] args) {
        // getCombimationsForSum("", 4);
        System.out.println(getCombimationsForSumRetList("",4));
        System.out.println(getCombimationsForSumRetListCustomFace("",7, 8));

    }
    private static List<String> getCombimationsForSumRetListCustomFace(String p, int up, int faceMax) {
        if (up == 0) { List<String> list = new ArrayList<>();
            System.out.println(p);list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= faceMax && i <= up; i++) {
            ans.addAll(     getCombimationsForSumRetListCustomFace(p + i, up - i, faceMax));
        }
return ans;
    }
    private static void getCombimationsForSum(String p, int up) {
        if (up == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= up; i++) {
            getCombimationsForSum(p + i, up - i);
        }

    }
    private static List<String> getCombimationsForSumRetList(String p, int up) {
        if (up == 0) { List<String> list = new ArrayList<>();
            System.out.println(p);list.add(p);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= up; i++) {
            ans.addAll(     getCombimationsForSumRetList(p + i, up - i));
        }
return ans;
    }
}
