public class insertion_sort {
    

    public static void main(String[] args) {
        int[] ar = new int[] {5,7,2,9,1,6};
        printarray(ar);
        insertionSort(ar);
    }

    private static void insertionSort(int[] ar) {
        int temp=0;
        for(int i=1;i<ar.length;i++){
            temp= ar[i];
            int j=i-1;
            for( j=i-1;j>=0;j--){
                if(temp > ar[j]){break;}
                else if(temp< ar[j]) {ar[j+1]=ar[j]; }
                System.out.print("-"+ar[j] +" ");
            }
            ar[j+1]=temp;
        }
        System.out.println();
        printarray(ar);
        
    }
    static void printarray(int[] arr){
        System.out.println();
        for(int i=0;i<arr.length;i++){System.out.print(arr[i]+" ");}
        System.out.println();
    }
}



/* 

Other way :

*/ 