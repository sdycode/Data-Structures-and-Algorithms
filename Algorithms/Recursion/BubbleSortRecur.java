import java.util.Arrays;

public class BubbleSortRecur {
    public static void main(String[] args) {
        int[] arr = { 5, 8, 6, 10, 23, 2 };

        // bubbleSortWithRec(arr, 0, 0);

        bubbleSortWithRecur2(arr, arr.length);
    }

    private static void bubbleSortWithRecur2(int[] arr, int length) {
        if (length == 1) {
            System.out.println("arr " + Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }

        }
         bubbleSortWithRecur2(arr, length-1);
    }

    private static void bubbleSortWithRec(int[] arr, int i, int j) {
        System.out.println(Arrays.toString(arr) + " i " + i);
        if (i == arr.length - 1) {
            System.out.println(Arrays.toString(arr) + " i " + i);
            return;
        }
        if (j < arr.length) {

            if (arr[j] > arr[i]) {
                swap(arr, j, i);

            }
            bubbleSortWithRec(arr, i, j + 1);

        } else {
            if (i < arr.length) {
                bubbleSortWithRec(arr, i + 1, i + 2);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
