
//  Remove all a from given string
public class String1 {
    public static void main(String[] args) {

        String s = "baaccba";
        // System.out.println(brutForce(s));
        // String ans = "";
        // ans = recurssionOutsideVariable(s, ans);
        // System.out.println(ans);

        String noextVarAns = recurssionAnsInsideFunction(s);
        System.out.println(noextVarAns);

    }

    private static String recurssionAnsInsideFunction(String s) {
        String ans = "";
        // System.out.println(s);
        if(s.isEmpty()){
            return ans;
        }
        if(s.toCharArray()[0]!='a'){
            ans = s.toCharArray()[0]+ recurssionAnsInsideFunction(s.substring(1));
        }
        else{
            ans =  recurssionAnsInsideFunction(s.substring(1));
        }
        // System.out.println(ans);
        return ans;
    }

    private static String recurssionOutsideVariable(String s, String ans) {
        if (s.isEmpty()) {
            return ans;
        }
        boolean a = s.toCharArray()[0] != 'a';
        if (s.toCharArray()[0] != 'a') {
            ans += s.toCharArray()[0];
        }
        return recurssionOutsideVariable(s.substring(1, s.length()), ans);
    }

    private static String brutForce(String s) {
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 'a') {
                builder.append(arr[i]);
            }
        }
        return builder.toString();
    }
}