import java.util.Arrays;

public class quick_sort {

    public static void main(String[] args) {
        int[] arr = { 4, 6, 8, 2, 7, 3 }
        // { 4, 6, 2, 5, 7, 9, 1, 3 }
        ;

        sortquickly(arr);
    }

    private static void sortquickly(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        quickSort(arr, l, h);
          System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int l, int h) {

        if (l < h) {
            int pivot = partition(arr, l, h);
            System.out.println("pivotpos " + pivot + " " + l + " " + h);
            if (l < pivot - 1) {
                quickSort(arr, l, pivot - 1);
            }
            if (h > pivot + 1) {
                quickSort(arr, pivot + 1, h);
            }

            System.out.println(Arrays.toString(arr));
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int pivotValue = arr[l];
        int i = l;
        int j = h;

        while (i < j) {
// System.out.println("check "+ arr);
            while (arr[i] <= pivotValue) {
               
                i++;
                if(i>= arr.length){
                    break;
                }


            }
            while (arr[j] > pivotValue) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, j, l);
        System.out.println("j is " + j);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
