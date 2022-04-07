import java.util.*;

public class BOJ14852 {
    static int X = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[][] dp = new long[N+1][2];
        dp[0][0] = 1;
        if(N > 0) dp[1][0] = 2;
        if(N > 1) dp[2][0] = 7;
        
        for(int i = 3; i <= N; i++) {
            dp[i][1] = (dp[i-3][0] + dp[i-1][1]) % X;
            dp[i][0] = (2*dp[i-1][0] + 3*dp[i-2][0] + 2*dp[i][1]) % X;
        }
        System.out.println(dp[N][0]);

        sc.close();
    }
}