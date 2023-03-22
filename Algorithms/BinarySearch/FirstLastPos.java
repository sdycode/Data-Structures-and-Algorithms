package BinarySearch;

import java.util.Arrays;

public class FirstLastPos {
    public static void main(String[] args) {
        int[] arr = {5,7,8,8,8,8,10};
        int l = -1, r = -1, t = 8;
//        System.out.println(Arrays.toString(findFirstLastPositions(arr, 0, arr.length - 1, l, r, t)));
//        int[] ans =findFirstLastPositions(arr, 0, arr.length - 1, l, r, t);
////        System.out.println("l " + l + " " + r);
//        System.out.println(Arrays.toString(ans));


// This is working and submitted to leetcode
        findFirstLastPositionsTwiceTraverse(arr,t);
    }

    private static int[] findFirstLastPositionsTwiceTraverse(int[] arr, int t) {

        int s=0,e=arr.length-1, l=-1, r=-1;

        // traverse for left value
        while (s<=e){
            int mid =s+(e-s)/2;
            if(t==arr[mid]){
                l=mid;
                e=mid-1;
            }

            if(t<arr[mid]){
                e=mid-1;
            }
            if(t>arr[mid]){
                s=mid+1;
            }
        }
        System.out.println("l "+l);
        // traverse for right value
        s=0;e=arr.length-1;
        while (s<=e){
            int mid =s+(e-s)/2;
            if(t==arr[mid]){
                r=mid;
                s=mid+1;
            }

            if(t<arr[mid]){
                e=mid-1;
            }
            if(t>arr[mid]){
                s=mid+1;
            }
        }
        System.out.println("r "+r);
return new int[]{l,r};
    }

    private static int[] findFirstLastPositions(int[] arr, int s, int e, int l, int r, int t) {
        int mid = s + (e - s) / 2;
        System.out.println(mid);
        if (s > e) {
            return new int[]{l, r};
        }
        if (t == arr[mid]) {
            if (l == -1) {
                l = mid;
            }
            if (mid > 0 && t == arr[mid - 1]) {
                l = Math.min(l, mid - 1);

            } else {
                l = Math.min(l, mid);
            }
            if (mid + 1 < arr.length && t == arr[mid + 1]) {
                System.out.println("rr "+(mid+1)+ "  "+ arr[mid + 1]);

                r = Math.max(r, mid + 1);
            } else {
                r = Math.max(r, mid);
                ;
            }

            System.out.println(mid + " l " + l + " r " + r);
        }
        if (t < arr[mid]) {
//           in left part
         return    findFirstLastPositions(arr, s, mid - 1, l, r, t);
        }
        if (t > arr[mid]) {
            return   findFirstLastPositions(arr, mid + 1, e, l, r, t);

        }
        return new int[]{l, r};

    }

}
