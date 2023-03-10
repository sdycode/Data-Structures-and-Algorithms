import java.util.Arrays;
import java.util.Scanner;

public class cyclic_sort1 {
    // This is to be used when we have array containing numbers from 0 to N or (m to m+n)
    // Complexity comes to (2N-1) in worst case
    // Algo is basically to check each no is at correct position or not
    // Steps :
    // start with index 0 and check weather it is at correct pos or not,
    // if not, swap this with its correct pos no,
    // then after swapping repeat same step again and again until no is at correct
    // position or not
    // and increment index go to next index and do the same.
    //

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int[] arr;
            int n;
            n = sc.nextInt();
            arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();

            }
            // sortFor0toN(arr);
            // 5
            // 4 2 0 1 3



            sortForMtoMplusN(arr);
        //   5
        // 10 8 7 9 11
            
        }

    }

    private static void sortForMtoMplusN(int[] arr) {
        int i =0;
        int m=0;
        for (int j = 0; j < arr.length; j++) {
        m = maxof(m, arr[j]);
        }
        m = m-arr.length+1;
        System.out.println("m is " +m);
        while (i<arr.length) {
            int element = arr[i];
            if(element != arr[element-m]){
                swap(arr, element-m, i);
                System.out.println("swap called on "+element+" "+i);
            }else{
                i++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int maxof(int m, int i) {
        if(m>i){
            return m;
        }
        return i;
    }

    private static void sortFor0toN(int[] arr) {

        int i = 0;
        while (i<arr.length) {
            int element =  arr[i];
            if(element != arr[element]){

                swap(arr, element, i);
                System.out.println("swap called on "+element+" "+i);
            }else{
                i++;
            }
            System.out.println(Arrays.toString(arr));
            
        }

    }

    private static void swap(int[] arr, int element, int i) {
        int temp = arr[i];
        arr[i]= arr[element];
        arr[element]= temp;
    }
}
