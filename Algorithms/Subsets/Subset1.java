package Algorithms.Subsets;

import java.util.*;
import java.util.ArrayList;

public class Subset1 {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 8,8 };
        // System.out.println(getSubsets(arr));
        System.out.println(getSubsetsWithDuplicates(arr));
        // List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // ans.add(new ArrayList<Integer>());
        // getSubsetsWithRec(arr, 0, ans);
        // System.out.println(ans);

    }

    private static void getSubsetsWithRec(int[] arr, int i, List<List<Integer>> ans) {

        if (i >= arr.length) {
            return;
        }
        int n = ans.size();
        for (int j = 0; j < n; j++) {
            ArrayList<Integer> internalList = new ArrayList<>(ans.get(j));
            internalList.add(arr[i]);
            ans.add(internalList);

        }
        getSubsetsWithRec(arr, i + 1, ans);
    }

    private static List<List<Integer>> getSubsets(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr) {
            int n = outer.size();
            // n is no of sub arrays/set present in outer in which new element will be added
            System.out.println(num + " " + n);
            for (int i = 0; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                // System.out.println(internal);
                outer.add(internal);
                // System.out.print(num+" ------ ");
                // System.out.println(outer);

            }
            n = outer.size();
            // System.out.println(num + " " + n);
        }

        return outer;
    }
//  with duplicates
    private static List<List<Integer>> getSubsetsWithDuplicates(int[] arr) {

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int j=0; j<arr.length ;j++) {
            int num = arr[j];
            int n = outer.size();
            int duplicacyLevel = 0;
            if(j>0){
                for (int k = j; k>0;k--) {
                    if(arr[k]== num){
                        duplicacyLevel++;
                    }
                    
                }

            }
            // n is no of sub arrays/set present in outer in which new element will be added
            System.out.println(num + " " + n);
            for (int i = duplicacyLevel; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                // System.out.println(internal);
                outer.add(internal);
                // System.out.print(num+" ------ ");
                // System.out.println(outer);

            }
            n = outer.size();
            System.out.println(num + " " + n);
        }

        return outer;
    }
}
