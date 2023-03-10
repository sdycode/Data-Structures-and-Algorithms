import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
      

        int[] arr = { 4, 6, 8, 2, 7, 3 };
        int n = arr.length;
        // swap(arr,2,4);
        System.out.println("array filled " + arr[2] + " " + arr[4]);
        quickSort(arr, 0, n - 1);
        System.out.println("sorted array is " + Arrays.toString(arr));
        // for(int a:arr){System.out.print(a);}
      
    }

    static void quickSort(int[] arr, int l, int r) {
        System.out.println(l + " firtst & lasst " + r);
        if (l < r) {
            int k = partition(arr, l, r);
            quickSort(arr, l, k - 1);
            System.out.println("next sort");
            quickSort(arr, k + 1, r);
        }

    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i, j;
        i = l;
        j = r;
        while (i < j) {
            System.out.println("you are in partition ");
            while (arr[i] <= pivot) {
                i++;
                if (i >= arr.length) {
                    break;
                }
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                System.out.println("after. swap " + i + " and " + j + " pivot is " + pivot);
                for (int a : arr) {
                    System.out.print(a + " ");
                }
            }
            System.out.println();

        }
        swap(arr, j, l);
        return j;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}