public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println(findInRotatedArray(arr, 1, 0, arr.length - 1));
        System.out.println(findInRotatedArray(arr, 2, 0, arr.length - 1));
        System.out.println(findInRotatedArray(arr, 9, 0, arr.length - 1));

    }

    private static int findInRotatedArray(int[] arr, int target, int s, int e) {

        int m = s + (e - s) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (s > e) {
            return -1;
        }
        // check left is sorted or targett
        if (arr[s] <= arr[m]) {
            // left sorted

            // check target lies in left range
            if (target >= arr[s] && target <= arr[m]) {
                return findInRotatedArray(arr, target, s, m - 1);
            } else {
                return findInRotatedArray(arr, target, m + 1, e);
            }
        }
        // check in right part as sorted
        if (target >= arr[m] && target <= arr[e]) {
            return findInRotatedArray(arr, target, m + 1, e);
        }

        return findInRotatedArray(arr, target, s, m - 1);

        // check

    }
}
