import java.util.*;

public class BOJ10844 {
    public static void main(String[] args) {
        long DIV = 1000000000;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        int[][] dp = new int[N+1][10];
        for(int j = 1; j < 10; j++) dp[1][j] = 1;

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                dp[i][j] += (j-1 >= 0) ? (dp[i-1][j-1]%DIV) : 0;
                dp[i][j] += (j+1 < 10) ? (dp[i-1][j+1]%DIV) : 0;
            }
        }
        long sum = 0;
        for(int j = 0; j < 10; j++) sum += dp[N][j];
        System.out.println(sum%DIV);
    }
}