

public class selection_sort {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n=9;
        // int[] arr;
        // // n = sc.nextInt();

        // arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // // arr[i] = sc.nextInt();
        // }
        // for (int i = 0; i < n; i++) {
        // // System.out.println(i+1+" : "+arr[i]);
        // }
        System.out.println();
        int[] ar = new int[] 
        
        {5,6,1,8,3,4}

        // { 8, 6, 2, 4, 2 }
        ;
        for (int k = 0; k < ar.length; k++) {
            System.out.print(" " + ar[k]);
        }
        selectionSort(ar);

    }

    private static void selectionSort(int[] arr) {

        // Selection sort means 1 swaping in 1 loop of traversal
        // find minimum element in array & swap with first element of loop
        // first element of loop means n'th element in nth iteration

        int index = 0;
        int temp = 0;
        int count= 0;
        for (int i = 0; i < arr.length-1; i++) {
         index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    
                    index = j;
                    
                }
                count++;
                System.out.println("count "+  count+" ");
            }
            // System.out.println(i);
            
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            

        }
    
        System.out.println("Final array is ");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(" " + arr[k]);
        }
    }

}
