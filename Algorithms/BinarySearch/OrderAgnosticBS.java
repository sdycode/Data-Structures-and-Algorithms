package BinarySearch;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 12,25,78,81,96 };
        int[] arrDe = new int[]{89,74,45, 12,8,6,2 };

        System.out.println(orderAgnosticbinarySearchIterate(arr, 81));
        System.out.println(orderAgnosticbinarySearchIterate(arrDe, 8));

    }

    private static int orderAgnosticbinarySearchIterate(int[] arr, int t) {

        boolean isAsc = arr[0]<=arr[arr.length-1];
        int s=0,e=arr.length-1;
        while (s<=e){
            int mid =  s+(e-s)/2;
            if(arr[mid]==t) {
                return mid;
            }
            if(isAsc){
                if(t<arr[mid]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else{
                if(t>arr[mid]){
                    e=mid-1;
                }else{
                    s=mid+1;
                }

            }
        }
        return -1;
    }
}
