import java.util.Arrays;
import java.util.Scanner;

public class bubble_sort1 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n;
            // n = sc.nextInt();
            // int[] arr;
            // arr = new int[n];
            // for (int i = 0; i < arr.length; i++) {
            //     arr[i] = sc.nextInt();

            // }
            int[] arr = { 5, 8, 6, 10, 23, 2 };
            for (int i = 0; i < arr.length; i++) {
             
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[i]>arr[j]){
                        int k =  arr[i];
                        arr[i] = arr[j];
                        arr[j] = k;
                    }
                    
                }
               
//                System.out.println();


            }
            
           System.out.println(Arrays.toString(arr));
        }
    }
}
