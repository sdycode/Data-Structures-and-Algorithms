import java.util.Scanner;

public class CheckRotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a="akash", b="ashak";
        // a = sc.next();
        // b = sc.next();
        if (a.length() != b.length()) {
            System.out.println("length false");
        } else {
            boolean clock = true;
            boolean antc = true;
            for (int i = 0; i < a.length(); i++) {
                // for clock
                int c = (i + 2) % a.length();
                if (a.charAt(i) != b.charAt(c)) {
                    clock = false;
                }
                int anc = (i - 2) % a.length();
                if(anc <0){
                    anc =  a.length()+anc;
                }
                if (a.charAt(i) != b.charAt(anc)) {
                    antc = false;
                }

            }
            System.out.println(clock+ " "+ antc);
            if(clock || antc){
                System.out.println("true");
            }else{
                System.out.println("false");

            }
        }


    }
}
