package LinkedList.Problems;

import java.util.HashMap;
import java.util.Map;

public class Happy {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappyUsingSlowFastPointerApproach(n));
        Map<Integer, Integer> map = new HashMap();
        System.out.println(isHappyUsingMap(n, map));
    }

    private static boolean isHappyUsingMap(int n, Map<Integer, Integer> map) {
        int sum = getSquareSum(n);
        if (map.containsKey(sum) && sum != 1) {
            return false;
        }
        map.put(sum, sum);
        if (sum == 1) {
            return true;
        }
        return isHappyUsingMap(sum, map);

    }

    private static int getSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }

    private static boolean isHappyUsingSlowFastPointerApproach(int n) {
        int slow =n;
        int fast = n;
        int sum=0;
        do {
            slow= getSquareSum(slow);
            fast= getSquareSum(getSquareSum(fast));
        }while (slow != fast);
        if(slow ==1){
            return  true;
        }
        return false;
    }
}
