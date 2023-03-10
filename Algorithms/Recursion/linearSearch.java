import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 41, 1, 0, 12, 41, 30, 41 };

        System.out.println(search(arr, 41, 0));
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(getArrayOfsearchIndexs(arr, ans, 45, 0));

        System.out.println(getArrayOfsearchIndexsWithouExternalList(arr, 41, 0));
    }

    private static ArrayList<Integer> getArrayOfsearchIndexsWithouExternalList(int[] arr, int no, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        if (i == arr.length - 1) {
            if (arr[i] == no) {
                list.add(i);
            }
            return list;
        }
        if (arr[i] == no) {
            list.add(i);
        }

        list.addAll(getArrayOfsearchIndexsWithouExternalList(arr, no, i + 1));
        return list;

    }

    private static ArrayList<Integer> getArrayOfsearchIndexs(int[] arr, ArrayList<Integer> ans, int no, int i) {
        if (arr[i] == no) {
            ans.add((i));
        }
        if (i == arr.length - 1) {

            return ans;
        }

        return getArrayOfsearchIndexs(arr, ans, no, i + 1);

    }

    private static int search(int[] arr, int no, int i) {

        if (i == arr.length - 1) {
            return arr[i] != no ? -1 : i;
        }
        return arr[i] == no ? i : search(arr, no, i + 1);
    }
}
