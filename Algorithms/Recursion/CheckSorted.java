public class CheckSorted {
    public static void main(String[] args) {
        int[] arr ={1,2,5,6,9,8};
    System.out.println(checkSorting(arr,0));
    }

    private static boolean checkSorting(int[] arr, int i ) {
        if(i== arr.length-1){
            return true;
        }
        if(arr[i]<arr[i+1]){
            return checkSorting(arr, i+1);
        }else{
            return false;
        }
        
    }
}
