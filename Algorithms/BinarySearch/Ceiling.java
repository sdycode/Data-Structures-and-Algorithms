package BinarySearch;

public class Ceiling {
    public static void main(String[] args) {
        int[] arr =new int[]{2,3,5,9,14,16,18};
        int t =8;
        System.out.println(ceieling(arr,0,arr.length-1,t));
    }

    private static int ceieling(int[] arr, int s, int e, int t) {
//        https://leetcode.com/problems/search-insert-position/submissions/916990984/

        int mid = s+(e-s)/2;
        if(arr[mid]==t){return mid;}
        if(s>e){
            return -1;
        }
        if(t>arr[mid]){
         return  ceieling(arr,mid+1,e,t);
        }else{
            if(mid>0 && t>arr[mid-1]){
                return  mid;
            }
            else{
                return ceieling(arr,s,mid-1,t);
            }
        }
    }
}
