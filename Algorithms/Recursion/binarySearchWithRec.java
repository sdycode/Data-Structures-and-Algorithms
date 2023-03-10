public class binarySearchWithRec {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 8, 20, 42, 78 };
System.out.println(binarySearch(arr, 20, 0, arr.length - 1));
        
    }

    private static int binarySearch(int[] arr, int no, int l, int h) {
        int m = (l + h) / 2;
        System.out.println("search called " + no + " l " + l + " " + h + " " + m);
        if (l > h) {
            return -1;
        }

        if (arr[m] == no) {
            System.out.println("search for  " + no + "  " + m);
            return m;
        }
        if (arr[m] > no) {
            System.out.println("search > ");
            return binarySearch(arr, no, l, m - 1);
        } else {

            return binarySearch(arr, no, m + 1, h);
        }
        // return m;
    }
}
