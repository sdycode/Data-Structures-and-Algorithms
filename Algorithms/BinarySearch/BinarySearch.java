package BinarySearch;


public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 12,25,78,81,96 };


//        System.out.println(binarySearchIterate(arr, 125));
        System.out.println(binarySRecur(arr,0,arr.length-1,25));
    }

    private static int binarySRecur(int[] arr, int s, int e, int t) {

        int mid =s+(e-s)/2;
        if(arr[mid]==t){return mid;}
        if(s>e){
            return  -1;
        }
        if(t<arr[mid]){
            return  binarySRecur(arr,s,mid-1,t);
        }else{
            return  binarySRecur(arr,mid+1,e,t);

        }

    }

    private static int binarySearchIterate(int[] arr, int target) {
        int s = 0, e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) return mid;
            if (target < arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
