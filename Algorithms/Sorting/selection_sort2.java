import java.util.Arrays;

public class selection_sort2 {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 8, 2, 7, 3 };

        selectionsort2(arr);
    }

    private static void selectionsort2(int[] arr) {
        int count = 0;
        // Approcah is find minimum in unsorted array (left part) and swap with first
        // element in unsorted array
        for (int i = 0; i < arr.length-1; i++) {
            int min =i;
          
            for (int j = i+1; j < arr.length; j++) {

                if (arr[j] < arr[min]) {
                    min = j;
                  
                }
                count++;
               
                // System.out.println("count " + count);
            }
           
            if (min != i) {
                swap(arr, min, i);
            }
           
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("count " + count);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }
}
