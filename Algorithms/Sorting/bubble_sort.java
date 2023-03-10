import java.util.Scanner;

class BubbleSort{
    public static void main(String[] args) {
        

        try (Scanner sc = new Scanner(System.in)) {
            int n;
            int[] arr;
            n = sc.nextInt();
      
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
            //    System.out.println(i+1+" : "+arr[i]);
            }
            System.out.println();
            // swap(5,12);
            bubbleSort(arr);
        }
    }

    private static void bubbleSort(int[] arr) {
        // int[] ans = new int[arr.length];

        for(int i=0;i<arr.length;i++){
            boolean sorted = true;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j-1]>arr[j]){
                    int t;
                    t= arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]=t;
                   // swap required means NOT sorted
                   sorted= false;
                }
                else{

                }
            }
            for(int k=0;k<arr.length;k++){System.out.print(arr[k]+" ");}
            System.out.println();
            if(sorted){break;}
        }
        for(int i=0;i<arr.length;i++){System.out.print(arr[i]+" ");}
        
    }
}