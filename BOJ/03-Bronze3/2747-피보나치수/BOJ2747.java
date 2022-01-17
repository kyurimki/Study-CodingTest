import java.util.*;

public class BOJ2747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 1, z = 1;

        for(int i = 2; i <= n; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        System.out.println(z);
        sc.close();
    }
}