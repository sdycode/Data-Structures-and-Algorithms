import java.util.Arrays;

public class SelectionSortRecur {

    public static void main(String[] args) {
        int[] arr = { 5, 6, 8, 1, 3, 7, 10 };
        // Selection sort is find minimum in unsorted array and place it in first
        // position in unsorted array
        // selectionsortRec(arr, 0);
        selectioSortWithLargestElement(arr);
    }

    private static void selectioSortWithLargestElement(int[] arr) {
        // take largest element and place at last pos
        for (int i = 0; i < arr.length; i++) {
            int largest = i;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[largest] < arr[j]) {
                    largest = j;
                }

            }
            int temp = arr[largest];
            arr[largest] = arr[arr.length - i -1];
            arr[arr.length - i -1] = temp;
            // if (largest != i) {
            // int temp = arr[largest];
            // arr[largest] = arr[i];
            // arr[i] = temp;
            // }

        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionsortRec(int[] arr, int i) {
        if (i == arr.length - 1) {
            return;
        }
        int min = i;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) {
                min = j;
            }
        }
        if (min != i) {
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
        selectionsortRec(arr, i + 1);
    }

    private static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
