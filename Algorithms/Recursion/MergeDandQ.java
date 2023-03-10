import java.util.Arrays;

public class MergeDandQ {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 8, 4, 9, 6, 12 };
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void divide(int[] arr, int s, int e) {
        if (e <= s) {
            return;
        }
        int mid = s + (e - s) / 2;

        divide(arr, s, mid);
        divide(arr, mid + 1, e);
        System.out.println("conquer " + mid + "  " + s);
        conquer(arr, s, mid, e);
        System.out.println(" after conquer " + mid);

    }

    private static void conquer(int[] arr, int s, int mid, int e) {
        int[] merged = new int[e - s + 1];
        int si = s;
        int ei = mid + 1;
        int ind = 0;
        while (si <= mid && ei <= e) {
            if (arr[si] < arr[ei]) {
                merged[ind] = arr[si];
                ind++;
                si++;
            } else {
                merged[ind] = arr[ei];
                ind++;
                ei++;
            }

        }
        // if left array is bigger
        while (si <= mid) {
            merged[ind] = arr[si];
            ind++;
            si++;

        }
        while (ei <= e) {
            merged[ind] = arr[ei];
            ind++;
            ei++;
        }
        System.out.println(si + " " + ei);
        for (int i = 0, j = s; i < merged.length; i++, j++) {

            arr[j] = merged[i];

        }
    }
}
