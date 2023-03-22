package Array;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr=  new int[]{7,2,5,10,8};
        int k =2;
        System.out.println(getLargestMinimisedSum(arr,k));
    }

    private static int getLargestMinimisedSum(int[] arr, int k) {
//        int largestArrSize = arr.length-(k-1);
        int largestArrSize = Math.max(arr.length/k,arr.length/k+ arr.length%k);
        System.out.println(largestArrSize+ " "+arr.length%k);
        int maxSum = 0;
        for (int i = 0; i <largestArrSize ; i++) {
            maxSum+=arr[i];

        }
int blockSum =  maxSum;
        for (int i = largestArrSize; i <arr.length ; i++) {
            int newSum = blockSum+arr[largestArrSize]-arr[i-largestArrSize];
            System.out.println("sum "+ i +" "+newSum+"  "+maxSum+" "+blockSum);
            maxSum = Math.max(maxSum,newSum);
        }
        return  maxSum;

    }
}
