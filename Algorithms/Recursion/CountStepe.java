public class CountStepe {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(countStepsTogetZero(n));
        System.out.println(countStepsTogetZero(8));
    }

    private static int countStepsTogetZero(int n) {
        // Rule if no is even reduce divide by 2 and 
        // subtact 1 for odd
        int count = 0;

        return helperCountStep(n, count);
    }

    private static int helperCountStep(int n, int count) {
        if (n == 0) {
            return count;
        }
        if (n % 2 == 0) {
            // Even
            count++;
            return helperCountStep(n / 2, count);

        } else {
            count++;
            return helperCountStep(n - 1, count);
        }
    }
}
