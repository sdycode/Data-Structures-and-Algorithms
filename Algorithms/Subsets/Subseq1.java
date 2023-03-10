package Algorithms.Subsets;

import java.util.ArrayList;

public class Subseq1 {

    public static void main(String[] args) {
        String s = "abc";
        // subseq1("", s);
        ArrayList<String> list =  subseqInList("", s);
        System.out.println(list);
        // ArrayList

    }

    private static ArrayList<String> subseqInList(String p, String up) {
        ArrayList<String> list = new ArrayList<String>() ;
        if (up.isEmpty()) {
            if(p.length()!=0){
                list.add(p);

            }
            // System.out.println(p);
            return list;
        }

        // Make left recursive call take previous p and and first letter of up
        list.addAll(   subseqInList(p + up.charAt(0), up.substring(1)));
        list.addAll(subseqInList(p, up.substring(1)));

        return  list;
    }

    private static void subseq1(String p, String up) {
        //
        // p is processed and up is unprocessed
        // processed is that we want and unprocessed is which will taken or used to get
        // processed
        // p will include empty string at start then
        // left call : p = previous p + first letter of unprocessed (take it)
        // right called : p = previous p (dont take any other)

        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        // Make left recursive call take previous p and and first letter of up
        subseq1(p + up.charAt(0), up.substring(1));
        subseq1(p, up.substring(1));

    }
}
