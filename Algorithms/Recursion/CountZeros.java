public class CountZeros {
    public static void main(String[] args) {
        int n = 4023000;
        System.out.println(getZeroCount(n));
        System.out.println(getZeroCountWithRec(n));

    }

    private static int getZeroCountWithRec(int n) {
        int count =0;
        return helperCount(n,count);
    }

    private static int helperCount(int n, int count) {
        if(n==0){
            return count;
        }
        if(n%10==0){
            count++;
        }
        return helperCount(n/10, count);
    }

    private static int getZeroCount(int n) {

        int count = 0;
        while (n != 0) {
            // System.out.println(count);
            if (n % 10 == 0) {
                count++;
            }
            n /= 10;

        }
        return count;
    }
}
