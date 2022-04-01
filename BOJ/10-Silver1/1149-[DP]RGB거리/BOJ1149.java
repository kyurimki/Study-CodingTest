import java.io.*;
import java.util.*;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int R = 0, G = 1, B = 2;
        int[][] cost = new int[N+1][3];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][3];
        dp[1][R] = cost[1][R];
        dp[1][G] = cost[1][G];
        dp[1][B] = cost[1][B];
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 3; j++)
                dp[i][j] = Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3]) + cost[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++)
            min = Math.min(min, dp[N][i]);
        System.out.println(min);
    }
}