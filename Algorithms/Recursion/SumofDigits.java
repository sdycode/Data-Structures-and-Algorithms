public class SumofDigits {

    public static void main(String[] args) {
        int n = 1214;
        System.out.println(sumUsingLoop(n));
        System.out.println(sumWithRecursion(n));
        System.out.println(prodOf(n));

    }

    private static int prodOf(int n) {
      if(n ==0){
        return 1;
      }
      return n%10 * prodOf(n/10);
    }

    private static int sumWithRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumWithRecursion(n / 10);
    }

    private static int sumUsingLoop(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;

        }
        return sum;
    }

}
