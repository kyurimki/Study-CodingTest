import java.util.*;

public class BOJ16486 {
    public static void main(String[] args) {
        double PI = 3.141592;

        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();

        System.out.println(2*(d1+PI*d2));
        sc.close();
    }
}