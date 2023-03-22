package BinarySearch;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakofMountain {
    public static void main(String[] args) {
        int[] arr = new int[]

//                {0,2,1,0};
                {0,8,10,7,6,5,4,3,2};
//                {0, 1,2,3,4,6,5,2};
//                {0, 10, 5, 2};
        int maxIndex = 0;
        System.out.println(getPeak(arr, 0, arr.length - 1, maxIndex));

        System.out.println(getPeakAppraoch2(arr));
    }

    private static int getPeakAppraoch2(int[] arr){
        // It is 2 pointer approach
        int n = arr.length, s,e, m, peak = 0;
        s  = 0;
        e = n - 1;
        while (s< e) {
            m = s+(e-s) / 2;
            if (arr[m] < arr[m + 1])
                s = peak = m + 1;
            else
                e = m;
        }
        return peak;
    }
    private static int getPeak(int[] arr, int s, int e, int maxIndex) {
        int mid = s + (e - s) / 2;
        if (s > e) {
            return maxIndex;
        }
        maxIndex = findMaxOf(arr, maxIndex, mid);
        // check mid is in decreasing array i.e MAX is in left part
        if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
            return getPeak(arr, 0, mid - 1, maxIndex);
        }
        else{
            return  getPeak(arr, mid+1, e, maxIndex);
        }

    }
    private static int findMaxOf(int[] arr, int maxIndex, int mid) {
        return arr[maxIndex] > arr[mid] ? maxIndex : mid;
    }

    ;

}
