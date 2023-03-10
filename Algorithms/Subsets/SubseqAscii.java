package Algorithms.Subsets;

import java.util.ArrayList;

public class SubseqAscii {
    public static void main(String[] args) {
        String s = "abc";
        // getSubseqWithAscii("", s);
        System.out.println(getSubseqWithAsciiInList("", s));

    }

    private static void getSubseqWithAscii(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        getSubseqWithAscii(p + up.charAt(0), up.substring(1));
        getSubseqWithAscii(p, up.substring(1));
        // Add this call where ascii is added in processed
        getSubseqWithAscii(p + (up.charAt(0) + 0), up.substring(1));

    }

    private static ArrayList<String> getSubseqWithAsciiInList(String p, String up) {
        ArrayList<String> list = new ArrayList<>();
        if (up.isEmpty()) {
            list.add(p);
            // System.out.print(p+" ");
            return list;
        }
        ArrayList<String> first = getSubseqWithAsciiInList(p + up.charAt(0), up.substring(1));
        ArrayList<String> second = getSubseqWithAsciiInList(p, up.substring(1));
        // Add this call where ascii is added in processed
        ArrayList<String> third = getSubseqWithAsciiInList(p + (up.charAt(0) + 0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;

    }
}
