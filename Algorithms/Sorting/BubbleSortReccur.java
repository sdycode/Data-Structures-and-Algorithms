import java.util.Arrays;

public class BubbleSortReccur {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 7, 6, 9, 12, 7};


        int[] ar = bubbleSortWithRec(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bubbleSortWithRec(int[] arr, int l) {
        if (l == arr.length) {
            return arr;
        }
        arr = bubbleInner(arr, l+1, l);
        return bubbleSortWithRec(arr,l+1);
    }

    private static int[] bubbleInner(int[] arr, int i, int l ) {
        if (i == arr.length) {
            return arr;
        }
        if (arr[i] < arr[ l]) {
            int t = arr[i];
            arr[i] = arr[ l];
            arr[ l] = t;
        }
        return  bubbleInner(arr,i+1, l);
    }
}
