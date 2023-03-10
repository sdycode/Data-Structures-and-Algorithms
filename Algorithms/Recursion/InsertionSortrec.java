import java.util.Arrays;

public class InsertionSortrec {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 1, 3, 9, 4 };
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        // place temp element (first in unsorted array) in correct pos in sorted array
        // by traversing through sorted array in backward direction

        for (int i = 1; i < arr.length ; i++) {
            int temp = arr[i];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}