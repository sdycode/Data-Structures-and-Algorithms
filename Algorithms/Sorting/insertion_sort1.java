import java.util.Arrays;

public class insertion_sort1 {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 6, 8, 1, 3, 12 };

        sortWithInsertion(arr);
    }

    private static void sortWithInsertion(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            System.out.println("temp " + temp);
            System.out.println(Arrays.toString(arr));
            for (int j = i - 1; j >= 0; j--) {
                count++;
                if (temp < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("count " + count);

        }
    }
}
