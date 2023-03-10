package Leetcode.problems;

public class binary1 {
    static String binary =
            // "100";
            // "101010";
            "0";
            // "0001010111";

    public static void main(String[] args) {

        int count0ateven = countForEven('0');
        int count1ateven = countForEven('1');
        int count0atodd = countForOdd('0');
        int count1atodd = countForOdd('1');
        int ans = Math.min(count1ateven + count0atodd, count0ateven + count1atodd);

        System.out.println(ans);

        // 0 at even

    }

    private static int countForOdd(char c) {
        int count = 0;
        for (int i = 1; i < binary.length(); i += 2) {
            if (binary.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    private static int countForEven(char c) {
        int count = 0;
        for (int i = 0; i < binary.length(); i += 2) {
            if (binary.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }
}
