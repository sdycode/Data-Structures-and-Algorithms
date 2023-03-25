package SlidingWindow;

public class MaxAvg {
    public static void main(String[] args) {
        int[] arr=
                {4,0,4,3,3};
//                {1,12,-5,-6,50,3};
        int k =5;
        System.out.println(findMaxAverage(arr,k));
    }
    public static double findMaxAverage(int[] arr, int k) {
        double maxSum = 0;
        int sum=0;
        int i=0,j=0, n= arr.length;
        if(n==1){
            return arr[0]/k;
        }
        if(n==0){
            return 0;
        }
        while(j<n){

            sum+= arr[j];
            System.out.println("sum  "+sum + " "+(j-i+1));
            if(j+1==k){

                maxSum  = Math.max(sum, maxSum);System.out.println(sum+" first "+maxSum);
                i++;
            }
            if(j-i+1==k && i>0){
                sum-= arr[i-1];
                maxSum  = Math.max(sum, maxSum);
                System.out.println(sum+" iter "+maxSum);
               i++;

            }

            j++;
        }
        double ans = (-55296/93 );
        System.out.println("Ans "+maxSum + " " +maxSum/k+ " an "+ans);
        return maxSum/k;
    }
}
