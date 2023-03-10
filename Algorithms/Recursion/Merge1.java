import java.util.Arrays;

public class Merge1 {
    public static void main(String[] args) {
        int[] arr1 = { 5, 6, 8 };
        int[] arr2 = { 4, 6, 7, 12,48 };
        int[] arr3 = merge2Arrays(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    private static int[] merge2Arrays(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];
        int min = arr1.length > arr2.length ? arr2.length : arr1.length;
        int max = arr1.length > arr2.length ? arr1.length : arr2.length;

        for (int i = 0; i < min; i++) {
            System.out.println("i " + i);
            int no = i*2;
            if (arr1[i] < arr2[i]) {
                ans[no] = arr1[i];
                ans[no + 1] = arr2[i];
               
            } else {
                ans[no] = arr2[i];
                ans[no + 1] = arr1[i];
               

            }
           
        }
        for (int i = min*2; i < min+max; i++) {
            ans[i]= arr1.length > arr2.length ? arr1[i-min]:arr2[i-min];
        }
        return ans;
    }
}
