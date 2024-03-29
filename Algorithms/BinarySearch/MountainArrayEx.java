package BinarySearch;

public class MountainArrayEx  {
    static int count =0;
    public static void main(String[] args) {
        int[] arr = new int[]
                {1,101,201,301,401,501,601,701,801,901,1001,1101,1201,1301,1401,1501,1601,1701,1801,1901,2001,2101,2201,2301,2401,2501,2601,2701,2801,2901,3001,3101,3201,3301,3401,3501,3601,3701,3801,3901,4001,4101,4201,4301,4401,4501,4601,4701,4801,4901,5001,5101,5201,5301,5401,5501,5601,5701,5801,5901,6001,6101,6201,6301,6401,6501,6601,6701,6801,6901,7001,7101,7201,7301,7401,7501,7601,7701,7801,7901,8001,8101,8201,8301,8401,8501,8601,8701,8801,8901,9001,9101,9201,9301,9401,9501,9601,9701,9801,9901,10001,10101,10201,10301,10401,10501,10601,10701,10801,10901,11001,11101,11201,11301,11401,11501,11601,11701,11801,11901,12001,12101,12201,12301,12401,12501,12601,12701,12801,12901,13001,13101,13201,13301,13401,13501,13601,13701,13801,13901,14001,14101,14201,14301,14401,14501,14601,14701,14801,14901,15001,15101,15201,15301,15401,15501,15601,15701,15801,15901,16001,16101,16201,16301,16401,16501,16601,16701,16801,16901,17001,17101,17201,17301,17401,17501,17601,17701,17801,17901,18001,18101,18201,18301,18401};

        int t = 1;
        int minIndex = -1;        int maxIndex = 0;

        int peakIndex= getPeak(arr, 0, arr.length - 1, maxIndex);
        System.out.println("peak "+peakIndex+ " count "+count);
        int minLeft = binarySRecur(arr, 0, peakIndex, t,false);
        int minRight = binarySRecur(arr, peakIndex+1, arr.length - 1, t,true);
        System.out.println("min "+minLeft + " "+minRight);
        int ans =-1;
        if(minLeft==-1){
            ans= minRight;
        }
        if(minRight==-1){
            ans= minLeft;

        }
        ans= Math.min(minLeft,minRight);

        System.out.println("ans " +ans+ " l "+minLeft+ " r "+minRight   + "count "+count );

        // Approach from leetcode

        MountainArrayEx mountainArrayEx = new MountainArrayEx()
;
//    mountainArrayEx.findInMountainArray(t,MountainArray());
    }
private  static int getValue(int[] arr, int i){
        count++;
        return  arr[i];
}
    private static int getPeak(int[] arr, int s, int e, int maxIndex) {
        int mid = s + (e - s) / 2;
        if (s > e) {
            return maxIndex;
        }
        maxIndex = findMaxOf(arr, maxIndex, mid);
        // check mid is in decreasing array i.e MAX is in left part
        if (mid + 1 < arr.length && getValue(arr,mid) > getValue(arr,mid+1)) {
            return getPeak(arr, 0, mid - 1, maxIndex);
        }
        else{
            return  getPeak(arr, mid+1, e, maxIndex);
        }

    }
    private static int findMaxOf(int[] arr, int maxIndex, int mid) {
        return arr[maxIndex] > getValue(arr,mid) ? maxIndex : mid;
    }
    private static int binarySRecur(int[] arr, int s, int e, int t, boolean descreseingArry) {

        int mid =s+(e-s)/2;
        System.out.println("mid "+mid + " s "+s+ " "+e );
        int midValue= getValue(arr,mid);
        if(midValue==t){return mid;}
        if(s>e){
            return  -1;
        }
        if(descreseingArry){
            if(t>midValue){
                return  binarySRecur(arr,s,mid-1,t, true);
            }else{
                return  binarySRecur(arr,mid+1,e,t, true);

            }
        }else{
            if(t<midValue){
                return  binarySRecur(arr,s,mid-1,t, true);
            }else{
                return  binarySRecur(arr,mid+1,e,t, true);

            }
        }


    }


    public int findInMountainArray(int target, MountainArray A) {    int n = A.length(), l, r, m, peak = 0;
        // find index of peak
        l  = 0;
        r = n - 1;
        while (l < r) {
            m = (l + r) / 2;
            if (A.get(m) < A.get(m + 1))
                l = peak = m + 1;
            else
                r = m;
        }
        // find target in the left of peak
        l = 0;
        r = peak;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) < target)
                l = m + 1;
            else if (A.get(m) > target)
                r = m - 1;
            else
                return m;
        }
        // find target in the right of peak
        l = peak;
        r = n - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (A.get(m) > target)
                l = m + 1;
            else if (A.get(m) < target)
                r = m - 1;
            else
                return m;
        }
        return -1;
    }

}
// For LeetCode interface is given
 interface MountainArray {
     public int get(int index) ;
      public int length() ;
  }
