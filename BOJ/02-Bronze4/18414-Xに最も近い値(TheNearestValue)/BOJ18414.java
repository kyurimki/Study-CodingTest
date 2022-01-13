import java.util.*;

public class BOJ18414 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();

        if(x < l) System.out.println(l);
        else if(x > r) System.out.println(r);
        else System.out.println(x);

        sc.close();
    }
}