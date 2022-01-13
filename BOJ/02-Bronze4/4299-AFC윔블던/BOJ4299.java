import java.util.*;

public class BOJ4299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int sub = sc.nextInt();

        double a = (double)(sum + sub) / 2;
        double b = sum - a;

        if(a < 0 || b < 0 || a != (int)Math.round(a)) System.out.println(-1);
        else {
            if(a >= b) System.out.println((int)a + " " + (int)b);
            else System.out.println((int)b + " " + (int)a);
        }
        sc.close();
    }
}