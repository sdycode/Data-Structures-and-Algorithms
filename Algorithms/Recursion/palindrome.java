public class palindrome {

    public static void main(String[] args) {
        int n = 4521254;

        System.out.println("palin " + isNoPalindrome(n));
        System.out.println("text palin " + isTextPalndrome("shugguhs"));
    }

    private static boolean isTextPalndrome(String string) {
        int i = 0;
        return helperText(string, i);
        // return false;
    }

    private static boolean helperText(String string, int i) {
        if (i > string.length() / 2) {
            return true;
        }
        if (string.charAt(i) == string.charAt(string.length() - 1 - i)) {
            return helperText(string, i + 1);
        }
        return false;
    }

    private static boolean isNoPalindrome(int n) {

        return n == rev(n);
    }

    private static int rev(int n) {

        int noOFdigits = (int) Math.log10(n) + 1;

        return helperForRev(n, noOFdigits);
    }

    private static int helperForRev(int n, int noOFdigits) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) (Math.pow(10, noOFdigits - 1)) + helperForRev(n / 10, noOFdigits - 1);
    }

}
