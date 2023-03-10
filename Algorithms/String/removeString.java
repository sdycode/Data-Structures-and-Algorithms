
// Remove particular string from given string
public class removeString {
    public static void main(String[] args) {
        String s = "helloguysbyguysheyguyboy";

        // String ans = removeGivenString(s, "guys");
        // remove guy only if it is not guys
        String ans = removeGivenSmallerStringIfBiggerNotPreseString(s, "guy", "guys");
        System.out.println(ans);

    }

    private static String removeGivenString(String s2, String string) {
        if (s2.isEmpty()) {
            return "";
        }
        if (s2.startsWith(string)) {
            return removeGivenString(s2.substring(string.length()), string);
        } else {
            return s2.charAt(0) + removeGivenString(s2.substring(1), string);
        }
    }

    private static String removeGivenSmallerStringIfBiggerNotPreseString(String s2, String string, String bigger) {
        if (s2.isEmpty()) {
            return "";
        }
        if (s2.startsWith(string) && !s2.startsWith(bigger)) {
            return removeGivenSmallerStringIfBiggerNotPreseString(s2.substring(string.length()), string, bigger);
        } else {
            return s2.charAt(0) + removeGivenSmallerStringIfBiggerNotPreseString(s2.substring(1), string, bigger);
        }
    }

}
