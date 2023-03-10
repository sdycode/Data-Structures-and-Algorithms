public class ReverseDigit {
    static int newno = 0;

    public static void main(String[] args) {
        int n = 4153;
        // System.out.println(reverseDigit(n));

        reverseDigitRecur(n);
        System.out.println("newno " + newno);

        System.out.println("revWithHelper "+ revWithHelper(n));
        System.out.println("countDigits "+countDigits(n));


    }

    private static int revWithHelper(int n) {

        // sometimes you need additional variables in argumnet
        // so you need to make another helper function
        int noOFdigits = (int) (Math.log10(n)) + 1;
        return helper(n, noOFdigits);

    }
private static int countDigits(int n) {

    int count  = 0;
    while (n !=0) {
        count++;
        n/=10;
        
    }
    return count;
    
}
    private static int helper(int n, int noOFdigits) {
        if(n%10==n){
            return n;
        }
        int rem  = n%10;

        return rem*(int)Math.pow(10, noOFdigits-1)+  helper(n/10, noOFdigits-1);
    }

    private static void reverseDigitRecur(int n) {

        // n/=10;
        if (n == 0) {
            return;
        }
        newno = newno * 10 + n % 10;
        reverseDigitRecur((n) / 10);

    }

    private static int reverseDigit(int n) {
        int ans = 0;
        while (n != 0) {
            ans = ans * 10 + n % 10;

            n /= 10;
        }
        return ans;

    }

}