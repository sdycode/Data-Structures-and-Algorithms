package BinarySearch;

public class InfiniteArray {

    public static void main(String[] args) {
        int[] arr = new int[]{0,             2,
                4,
                6,
                8,
                10,
                12,
                14,
                16,
                18,
                20,
                22,
                24,
                26,
                28,
                30,
                32,
                34,
                36,
                38,
                40,
                42,
                44,
                46,
                48,
                50,
                52,
                54,
                56,
                58,
                60,
                62,
                64,
                66,
                68,
                70,
                72,
                74,
                76,
                78,};


        int t = 74;
        int chunkSize = 2;
        int s=0,e=s+chunkSize-1;
        System.out.println("ans "+getBSRange(arr,s,e,t) );



    }

    private static int getBSRange(int[] arr, int s, int e, int t) {
        if(t>=arr[s] && t<=arr[e]){
            return  applyBS(arr,s,e,t);
        }
        int newChunkSize  = (e-s)*2;
        s=e+1;
        e=s+newChunkSize;
        System.out.println("chunked "+s+ " "+e);
        return  getBSRange(arr,s,e,t);

    }

    private static int applyBS(int[] arr, int s, int e, int t) {
        while (s<=e){
            int mid =s+(e-s)/2;
            if(t==arr[mid]){
                return  mid;
            }
            if(t<arr[mid]){
                return  applyBS(arr,s,mid-1,t);
            }else{
                return  applyBS(arr,mid+1,e,t);

            }
        }
        return  -1;
    }
}
