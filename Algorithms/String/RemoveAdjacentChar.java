public class RemoveAdjacentChar {

    public static void main(String[] args) {
        String s ="abccbccba";

        String ans =  removeDup(s,0, s.length());
        System.out.println(ans);
    }

    private static String removeDup(String s,int i,int l) {

        if(i>= s.length()){
            return s;
        }
        System.out.println(s + " " +i);
        if(s.charAt(i)==s.charAt(i+1)){
            return  removeDup(s.substring(0,i)+ s.substring(i+2),i+1 ,s.length());
        }
     else{
         return removeDup(s,i+1,s.length());
        }
    }
}
