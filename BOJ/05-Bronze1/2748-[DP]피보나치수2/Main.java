import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[91];

        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i < n+1; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[n]);
        sc.close();
    }
}