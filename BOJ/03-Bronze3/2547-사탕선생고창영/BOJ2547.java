import java.util.*;

public class BOJ2547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            long candies = 0;
            for(int j = 0; j < n; j++) {
                long tmp = sc.nextLong();
                candies += tmp % n;
            }

            if(candies % n == 0) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}