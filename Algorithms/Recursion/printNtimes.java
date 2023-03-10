public class printNtimes {
    public static void main(String[] args) {
        // print message n times using recursion;
        int n = 5;
        printMessageReverse(n,"This is message reversed ");
        printMessage(0,"This is message ", n);
    }

    private static void printMessageReverse(int n, String string) {
        System.out.println(string);
        if(n==0){
           
            return;
        }
        printMessageReverse(n-1, "Message is revers "+ n);
    }
    private static void printMessage(int n, String string, int n2) {
        
        if(n==n2){
           
            return;
        }else{

        }
        System.out.println(string);
        printMessage(n+1, "Message is at "+ n, n2);
    }
}
