package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {


    // Driver code
    public static void main(String args[]) {
        String text = "forxxorfxdofr";
        String word = "for";
        System.out.print(countAnagrams(text, word));
    }

    public static int countAnagrams(String s, String sub) {
        // change CHARACTERS to support range of supported
        // characters
        int CHARACTERS = 256;
        int sn = s.length();
        int pn = sub.length();
        int count = 0;
        if (sn < 0 || pn < 0 || sn < pn)
            return 0;

        char[] subArr = new char[CHARACTERS];
        char[] sArr = new char[CHARACTERS];
        int i = 0;
        // till window size
        for (; i < pn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            subArr[CHARACTERS - sub.charAt(i)]++;
        }
        if (Arrays.equals(subArr, sArr))
            count += 1;
        // next window
        for (; i < sn; i++) {
            sArr[CHARACTERS - s.charAt(i)]++;
            sArr[CHARACTERS - s.charAt(i - pn)]--;

            if (Arrays.equals(subArr, sArr))
                count += 1;
        }
        return count;
    }
}
