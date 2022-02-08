import java.util.*;

public class BOJ2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long count2 = count(n, 2) - count(n-m, 2) - count(m, 2);
        long count5 = count(n, 5) - count(n-m, 5) - count(m, 5);

        System.out.println(Math.min(count2, count5));

        sc.close();
    }

    private static long count(int x, int y) {
        long cnt = 0;
        while(x >= y) {
            cnt += x / y;
            x /= y;
        }
        return cnt;
    }
}