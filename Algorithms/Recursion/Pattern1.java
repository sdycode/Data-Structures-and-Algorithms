/*
 drawHigherToLowerLeftPattern
******
*****
****
***
**
*

 */

/*
drawHigherToLowerRightPattern
*****
****
 ***
  **
   *

*/

/*

topPoint pyramid

   *  
  ***
 *****
 
 */
public class Pattern1 {

    public static void main(String[] args) {
        int n = 4;
        // drawHigherToLowerLeftPattern(n);

        // drawHigherToLowerRightPattern(n, n, "*");
        // int max = n%2==0 ? n*2-1:
      drawTopPointPyramid(n, n*2-1,"*");
    }

   

   

    private static void drawTopPointPyramid(int n, int max, String string) {
        if(n==0){
            return ;
        }
      
        drawTopPointPyramid(n-1, max, string);
        drawCharInLineSpaceAroud((max -2*n-1)/2 , max, string);
        
    }





    private static void drawCharInLineSpaceAroud(int left, int max, String string) {
        for(int i=0;i<max;i++){
            if(i<=left || i>= max-left-1){
                System.out.print(" ");
            }else{
                System.out.print(string);
            }
           
        }
        System.out.println();
    }





    private static void drawHigherToLowerLeftPattern(int n) {
        if (n == 0) {
            return;
        }

        // way 3
        drawCharInLine(n, "*");
        System.out.println();

        drawHigherToLowerLeftPattern(n - 1);
    }

    private static void drawHigherToLowerRightPattern(int n, int max, String string) {

        if (n == 0) {
            return;
        }
        drawCharInLine(max - n, " ");
        drawCharInLine(n, string);
        System.out.println();
        drawHigherToLowerRightPattern(n - 1, max, string);

    }

    private static void drawCharInLine(int n, String string) {
        // Way 1
        // String repeated = new String(new char[n]).replace("\0", "*");
        // System.out.println(repeated);

        // way 2
        // for (int i = 0; i < n; i++)
        // System.out.print("*");
        // System.out.println();
        if (n == 0) {

            return;
        }
        System.out.print(string);
        drawCharInLine(n - 1, string);
    }

}
