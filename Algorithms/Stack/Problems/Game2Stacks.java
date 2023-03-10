package Problems;

import java.util.Arrays;
import java.util.Stack;

/*
Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve.

Example


The maximum number of values Nick can remove is . There are two sets of choices with this result.

Remove  from  with a sum of .
Remove  from  and  from  with a sum of .
Function Description
Complete the twoStacks function in the editor below.

twoStacks has the following parameters: - int maxSum: the maximum allowed sum
- int a[n]: the first stack
- int b[m]: the second stack

Returns
- int: the maximum number of selections Nick can make

Input Format

The first line contains an integer,  (the number of games). The  subsequent lines describe each game in the following format:

The first line contains three space-separated integers describing the respective values of  (the number of integers in stack ),  (the number of integers in stack ), and  (the number that the sum of the integers removed from the two stacks cannot exceed).
The second line contains  space-separated integers, the respective values of .
The third line contains  space-separated integers, the respective values of .

1
5 4 10
4 2 4 6 1
2 1 8 5
 */
public class Game2Stacks {

    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 4, 6, 1};
        int[] b = new int[]{2, 1, 8, 5};
        int maxSum = 10;
//        System.out.println(getMaxScore(maxSum, a, b));
        System.out.println(findMaxScore(maxSum, a, b));
    }

    private static int findMaxScore(int maxSum, int[] a, int[] b) {
        return findMaxScore(maxSum, a, b, 0, 0) - 1;
    }

    private static int findMaxScore(int maxSum, int[] a, int[] b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        if(a.length==0 || b.length==0){
            return  count;
        }

        int countOfA = findMaxScore(maxSum, Arrays.copyOfRange(a,1,a.length), b, sum+a[0],count+1);
        int countOfB = findMaxScore(maxSum, a,  Arrays.copyOfRange(b,1, b.length), sum+b[0],count+1);


        return Math.max(countOfA,countOfB);
    }

    private static int getMaxScore(int maxSum, int[] a, int[] b) {
        int maxscore = 0;
        // travers throu a and find max depth
        int suma = 0;
        int aMax = 0;
        int sumb = 0;
        int bMax = 0;
        for (int i = 0; i < a.length; i++) {

            if (suma + a[i] > maxSum) {
                aMax = i;
                break;
            } else {
                suma += a[i];
                System.out.println("a" + suma + "  " + i);
            }

        }

        for (int i = 0; i < b.length; i++) {

            if (sumb + b[i] > maxSum) {
                bMax = i;
                break;
            } else {
                sumb += b[i];
                System.out.println("b" + sumb + "  " + i);
            }


        }
        System.out.println(aMax + " " + bMax);


        return maxscore;
    }

}
