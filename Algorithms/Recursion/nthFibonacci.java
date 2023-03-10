public class nthFibonacci {
    static int a=0, b= 1, c; 
    public static void main(String[] args) {
        int n = 6;
        // System.out.println(getNthFibonacci(n));
        System.out.print(a+" "+b+" ");
        printFibonacciSeriesuptoNnumbers(n);
    }

    private static void printFibonacciSeriesuptoNnumbers(int n) {
       if(n>=1){
            // System.out.println(printFibonacciSeriesuptoNnumbers(n - 1) + printFibonacciSeriesuptoNnumbers(n - 2));
            // printFibonacciSeriesuptoNnumbers
            c=a+b;
           System.out.print(c+" ");
           a = b;
           b =c;
           printFibonacciSeriesuptoNnumbers(n-1);
        }
    }

    private static int getNthFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else {
            return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
        }
        // return getNthFibonacci(n-1);
    }
}
