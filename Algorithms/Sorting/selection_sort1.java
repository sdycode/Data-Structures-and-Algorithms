import java.util.Arrays;

public class selection_sort1 {
    public static void main(String[] args) {
        int[] arr =

                { 5, 6, 1, 8, 3, 4 }
        // {8,6,5,3,1}
        ;
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < arr.length - i; j++) {
                max = arr[max] > arr[j] ? max : j;

                // System.out.print(max+" "+(arr.length-1-i)+" " );
                count++;
                System.out.println("count " + count);

            }

            if (max == arr.length - 1 - i) {
                System.out.println(Arrays.toString(arr));
                break;
            }
            swap(arr, max, arr.length - 1 - i);
            System.out.println(Arrays.toString(arr));

        }
    }

    private static void swap(int[] arr, int max, int i) {
        int temp = arr[max];
        arr[max] = arr[i];
        arr[i] = temp;
    }

}
