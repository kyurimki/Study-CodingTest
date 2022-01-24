import java.util.*;

public class BOJ2028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String n2 = Integer.toString(n*n);
            if(Integer.toString(n).equals(n2.substring(n2.length()-Integer.toString(n).length()))) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}